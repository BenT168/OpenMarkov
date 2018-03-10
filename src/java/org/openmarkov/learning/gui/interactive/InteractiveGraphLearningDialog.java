/*
* Copyright 2011 CISIAD, UNED, Spain
*
* Licensed under the European Union Public Licence, version 1.1 (EUPL)
*
* Unless required by applicable law, this code is distributed
* on an "AS IS" basis, WITHOUT WARRANTIES OF ANY KIND.
*/

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InteractiveLearningGUI.java
 *
 * Created on 08-may-2011, 12:30:57
 */

package org.openmarkov.learning.gui.interactive;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.UndoableEditEvent;

import org.openmarkov.core.action.PNEdit;
import org.openmarkov.core.action.PNUndoableEditListener;
import org.openmarkov.core.exception.CanNotDoEditException;
import org.openmarkov.core.exception.ConstraintViolationException;
import org.openmarkov.core.exception.NonProjectablePotentialException;
import org.openmarkov.core.exception.NormalizeNullVectorException;
import org.openmarkov.core.exception.WrongCriterionException;
import org.openmarkov.core.gui.action.MoveNodeEdit;
import org.openmarkov.core.gui.localize.StringDatabase;
import org.openmarkov.core.model.network.type.BayesianNetworkType;
import org.openmarkov.learning.core.LearningManager;
import org.openmarkov.learning.core.util.LearningEditProposal;
import org.openmarkov.learning.gui.interactive.EditProposalTable.EditSelectionListener;
import org.openmarkov.learning.gui.interactive.EditProposalTable.EditionEvent;

/**
 *
 * @author Inigo
 */
@SuppressWarnings("serial")
public class InteractiveGraphLearningDialog extends javax.swing.JDialog implements EditSelectionListener, PNUndoableEditListener {
	
    public static int SHOWING_EDIT_NUM = 8;

    /** Creates new form InteractiveLearningGUI */
    public InteractiveGraphLearningDialog(JFrame parent, boolean modal, LearningManager learningManager) {
        super(parent, modal);
        this.learningManager = learningManager;
        this.learningManager.getLearnedNet().getPNESupport().setWithUndo(true);
        this.learningManager.getLearnedNet().getPNESupport().addUndoableEditListener(this);
        editionsTable = new EditProposalTable();
        editionsTable.addEditSelectionListener(this);
        initComponents();
        jScrollPane1.setViewportView(editionsTable);
		updateEditionsTable(onlyAllowed, onlyPositive, learningManager.getBlockedEdits());	
        this.setLocation (parent.getLocationOnScreen ().x
                                  + parent.getSize ().width
                                  - this.getSize ().width,
                          140 + parent.getLocationOnScreen ().y);
        //	this.blockedEditDialog = new BlockedEditDialog(this, false);
    	
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	generalTabbedPane = new javax.swing.JTabbedPane();
    	editionTablePanel = new javax.swing.JPanel();
    	lookaheadPanel = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        chkOnlyAllowedEdits = new javax.swing.JCheckBox();
        chkOnlyPositiveEdits = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRedo = new javax.swing.JButton();
        btnBlockEdit = new javax.swing.JButton();
        btnShowBlocked = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();
        btnRun = new javax.swing.JButton();
        btnNextPhase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Interactive Graph Learning");
        setResizable(true);
        setMinimumSize(new Dimension(650, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnEdit.setText(stringDatabase.getString ("Learning.Interactive.ApplyEdit"));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnUndo.setText(stringDatabase.getString ("Learning.Interactive.Undo"));
        btnUndo.setEnabled(false);
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        chkOnlyAllowedEdits.setSelected(true);
        chkOnlyAllowedEdits.setText(stringDatabase.getString ("Learning.Interactive.OnlyAllowedEdits"));
        chkOnlyAllowedEdits.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkOnlyAllowedEditsStateChanged(evt);
            }
        });

        chkOnlyPositiveEdits.setSelected(true);
        chkOnlyPositiveEdits.setText(stringDatabase.getString ("Learning.Interactive.OnlyPositiveEdits"));
        chkOnlyPositiveEdits.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkOnlyPositiveEditsStateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnRedo.setText(stringDatabase.getString ("Learning.Interactive.Redo"));
        btnRedo.setEnabled(false);
        btnRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedoActionPerformed(evt);
            }
        });

        btnBlockEdit.setText(stringDatabase.getString ("Learning.Interactive.BlockEdit"));
        btnBlockEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockEditActionPerformed(evt);
            }
        });

        btnShowBlocked.setText(stringDatabase.getString ("Learning.Interactive.ShowBlocked"));
        btnShowBlocked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowBlockedActionPerformed(evt);
            }
        });

        lblScore.setText(stringDatabase.getString ("Learning.Interactive.Score") + ": ");
        lblScore.setVisible (false);

        btnRun.setText(stringDatabase.getString ("Learning.Interactive.Run"));
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });
        btnRun.setToolTipText (stringDatabase.getString ("Learning.Interactive.Run.ToolTip"));

        btnNextPhase.setText(stringDatabase.getString ("Learning.Interactive.NextPhase"));
        btnNextPhase.setToolTipText("");
        btnNextPhase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPhaseActionPerformed(evt);
            }
        });
        
        btnNextPhase.setToolTipText (stringDatabase.getString ("Learning.Interactive.NextPhase.ToolTip"));
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(generalTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
//            .add(layout.createSequentialGroup()
//                .add(170, 170, 170)
//                .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
//                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(generalTabbedPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 359, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
               // .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
        javax.swing.GroupLayout editionTableLayout = new javax.swing.GroupLayout(editionTablePanel);
        editionTablePanel.setLayout(editionTableLayout);
        editionTableLayout.setHorizontalGroup(
        	editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        	.addGroup(editionTableLayout.createSequentialGroup()
        		.addContainerGap()
        		.addGroup(editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, 300, 500, Short.MAX_VALUE)
                    .addGroup(editionTableLayout.createSequentialGroup()
                    	.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                        .addComponent(btnUndo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                        .addComponent(btnRedo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                        .addComponent(btnNextPhase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                        .addComponent(btnRun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScore)
                    .addGroup(editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnBlockEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnShowBlocked, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(chkOnlyPositiveEdits)
                    .addComponent(chkOnlyAllowedEdits))
                .addContainerGap())           
        );
      editionTableLayout.setVerticalGroup(
      editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(editionTableLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(editionTableLayout.createSequentialGroup()
                  .addComponent(chkOnlyAllowedEdits)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(chkOnlyPositiveEdits)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btnBlockEdit)
                  .addGap(8, 8, 8)
                  .addComponent(btnShowBlocked))
              .addComponent(jScrollPane1, 50, 155, Short.MAX_VALUE))
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lblScore)
              .addGroup(editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(btnEdit)
                  .addComponent(btnUndo)
                  .addComponent(btnRedo)
                  .addComponent(btnRun)
                  .addComponent(btnNextPhase)))
          .addContainerGap())
  );
      generalTabbedPane.addTab(stringDatabase.getString("Learning.General"), editionTablePanel); 
      
      javax.swing.GroupLayout lookaheadLayout = new javax.swing.GroupLayout(lookaheadPanel);
      lookaheadPanel.setLayout(lookaheadLayout);
      lookaheadLayout.setHorizontalGroup(
          	lookaheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          	.addGroup(lookaheadLayout.createSequentialGroup()
          		.addContainerGap()
          		//first a component of network graph and then a group of slider bar + reset button
          		.addComponent(jScrollPane1, 300, 500, Short.MAX_VALUE)
          		.addGap(18, 18, 18)
              .addContainerGap())           
          );
      lookaheadLayout.setVerticalGroup(
    	      lookaheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    	      .addGroup(lookaheadLayout.createSequentialGroup()
    	          .addContainerGap()
    	          .addGroup(editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    	        		  //network panel here
    	              .addComponent(jScrollPane1, 50, 155, Short.MAX_VALUE))
    	          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
    	          .addGroup(editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    	              .addGroup(editionTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
    	                  .addComponent(btnNextPhase)))
    	          .addContainerGap())
    	  );
      
      generalTabbedPane.addTab("Look Ahead Graph", lookaheadPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {                                        
		applySelected();
    }                                       

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
		learningManager.getLearnedNet().getPNESupport().undo();
    }//GEN-LAST:event_btnEditActionPerformed

    private void chkOnlyAllowedEditsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkOnlyAllowedEditsStateChanged
    	if(onlyAllowed != chkOnlyAllowedEdits.isSelected())
    	{
    		onlyAllowed = chkOnlyAllowedEdits.isSelected();
	        updateEditionsTable(onlyAllowed, onlyPositive, learningManager.getBlockedEdits());
    	}
    }//GEN-LAST:event_chkOnlyAllowedEditsStateChanged

    private void chkOnlyPositiveEditsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkOnlyPositiveEditsStateChanged
    	if(onlyPositive != chkOnlyPositiveEdits.isSelected())
    	{
    		onlyPositive = chkOnlyPositiveEdits.isSelected();
	        updateEditionsTable(onlyAllowed, onlyPositive, learningManager.getBlockedEdits());
    	}
    }//GEN-LAST:event_chkOnlyPositiveEditsStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    private void btnRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedoActionPerformed
		learningManager.getLearnedNet().getPNESupport().redo();
    }//GEN-LAST:event_btnRedoActionPerformed

    private void btnBlockEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockEditActionPerformed
		if(editionsTable.getSelectedEdit() != null)
		{
        	learningManager.blockEdit(editionsTable.getSelectedEdit());
        	updateEditionsTable(onlyAllowed, onlyPositive, learningManager.getBlockedEdits());
        }
    }//GEN-LAST:event_btnBlockEditActionPerformed

	private void btnShowBlockedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowBlockedActionPerformed
       	blockedEditDialog.setLocation(this.getX()+this.getWidth()-blockedEditDialog.getWidth(), this.getY()+this.getHeight());
        blockedEditDialog.setVisible(true);
    }//GEN-LAST:event_btnShowBlockedActionPerformed

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        try
        {
            learningManager.learn ();
            this.setVisible (false);
        }
        catch (NormalizeNullVectorException e)
        {
            JOptionPane.showMessageDialog (null,
                                           stringDatabase.getString ("Learning.Error")
                                                   + ":" + e.getMessage (),
                                                   stringDatabase.getString ("ErrorWindow.Title.Label"),
                                           JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnRunActionPerformed

    private void btnNextPhaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPhaseActionPerformed
    	try
        {
    		learningManager.getLearnedNet ().getPNESupport ().removeUndoableEditListener (this);
	    	learningManager.goToNextPhase ();
	        updateEditionsTable (onlyAllowed, onlyPositive, learningManager.getBlockedEdits ());
	        learningManager.getLearnedNet ().getPNESupport ().addUndoableEditListener (this);
	        btnRedo.setEnabled(false);
	        btnUndo.setEnabled(true);
        }
        catch (NormalizeNullVectorException e)
        {
            JOptionPane.showMessageDialog (null,
                                           stringDatabase.getString ("Learning.Error")
                                                   + ":" + e.getMessage (),
                                                   stringDatabase.getString ("ErrorWindow.Title.Label"),
                                           JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNextPhaseActionPerformed
    
	public void editionPerformed(EditionEvent editionEvent) {
		applySelected();
	}
	
	public void editionUnblocked(PNEdit edit)
	{
		learningManager.unblockEdit(edit);
		updateEditionsTable(onlyAllowed, onlyPositive, learningManager.getBlockedEdits());
		
	}

	private void applySelected()
	{
    	try
    	{
    		if(editionsTable.getSelectedEdit() != null)
    		{
    			learningManager.applyEdit (editionsTable.getSelectedEdit());
    		}
    		
		} catch (Exception e) {
            JOptionPane.showMessageDialog (null,
                                           stringDatabase.getString ("Learning.Error")
                                                   + ":" + e.getMessage (),
                                                   stringDatabase.getString ("ErrorWindow.Title.Label"),
                                           JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} 
    	
	}
	
	public void undoableEditHappened(UndoableEditEvent event) {
        if(!(event.getEdit() instanceof MoveNodeEdit))
        {
			updateEditionsTable(onlyAllowed, onlyPositive, learningManager.getBlockedEdits());
        }
        if (!learningManager.getLearnedNet().getPNESupport().getUndoManager().canRedo())
        	btnRedo.setEnabled(false);
        btnUndo.setEnabled(true);
	}

	public void undoEditHappened(UndoableEditEvent event) {
			updateEditionsTable(onlyAllowed, onlyPositive, learningManager.getBlockedEdits());
			btnRedo.setEnabled(true);
			if (!learningManager.getLearnedNet().getPNESupport().getUndoManager().canUndo())
				btnUndo.setEnabled(false);
	}
	
	public void undoableEditWillHappen(UndoableEditEvent event)
			throws ConstraintViolationException, CanNotDoEditException,
			NonProjectablePotentialException,
			WrongCriterionException {
	}
	
	private void updateEditionsTable(boolean onlyAllowed, boolean onlyPositive, List<PNEdit> blockedEdits) 
	{
		List<LearningEditProposal> showableEditProposals = new ArrayList<LearningEditProposal>();
		List<LearningEditProposal> blockedEditProposals = new ArrayList<LearningEditProposal>();
		
		LearningEditProposal bestEdition = learningManager.getBestEdit(onlyAllowed, onlyPositive);
		while(showableEditProposals.size() < SHOWING_EDIT_NUM && bestEdition!=null)
		{
			showableEditProposals.add(bestEdition);
			bestEdition = learningManager.getNextEdit(onlyAllowed, onlyPositive);
		}
		
		editionsTable.fill(showableEditProposals); 
		try {
			if (showableEditProposals.isEmpty ())
				learningManager.getLearnedNet ().setNetworkType (BayesianNetworkType.getUniqueInstance ());
		} catch (ConstraintViolationException e) {
				e.printStackTrace ();
		}
		
        if(blockedEditDialog != null)
        {
			for(PNEdit blockedEdit : blockedEdits)
				blockedEditProposals.add(new LearningEditProposal(blockedEdit, learningManager.getMotivation(blockedEdit)));

			blockedEditDialog.fill(blockedEditProposals);
        }
        
        btnNextPhase.setEnabled (!showableEditProposals.isEmpty ());
        btnRun.setEnabled (!showableEditProposals.isEmpty ());
        btnEdit.setEnabled (!showableEditProposals.isEmpty ());
	}
	
	//get jScrollPane1
	public static JScrollPane getjPanel1() {

			return jScrollPane1;
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlockEdit;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNextPhase;
    private javax.swing.JButton btnRedo;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnShowBlocked;
    private javax.swing.JButton btnUndo;
    private javax.swing.JCheckBox chkOnlyAllowedEdits;
    private javax.swing.JCheckBox chkOnlyPositiveEdits;
    private static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblScore;
    private javax.swing.JTabbedPane generalTabbedPane;
    private javax.swing.JPanel editionTablePanel;
    private javax.swing.JPanel lookaheadPanel;
    // End of variables declaration//GEN-END:variables

    private EditProposalTable editionsTable;
	private LearningManager learningManager;
	private boolean onlyAllowed = true, onlyPositive = true;
    private BlockedEditDialog blockedEditDialog;
    /**
     * String database 
     */
    protected StringDatabase stringDatabase = StringDatabase.getUniqueInstance ();	    
}