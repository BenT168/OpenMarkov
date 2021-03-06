// $ANTLR : "elviraDB.g" -> "ElviraDBParser.java"$

    package org.openmarkov.io.database.elvira;
    import org.apache.log4j.Logger;
	import org.openmarkov.core.model.network.NodeType;
	import org.openmarkov.core.model.network.ProbNet;
	import org.openmarkov.core.model.network.ProbNode;
	import org.openmarkov.core.model.network.State;
	import org.openmarkov.core.model.network.Variable;
	import org.openmarkov.core.model.network.type.BayesianNetworkType;
	import org.openmarkov.core.model.network.VariableType;
    import java.util.*;
    import java.lang.Integer;
    import java.util.Map.Entry;

public interface ElviraDBLexerTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int QUOTATION = 4;
	int DATABASE = 5;
	int WHITE = 6;
	int REMARK = 7;
	int COMMENT = 8;
	int SEPARATOR = 9;
	int IDENT = 10;
	int STRING = 11;
	int TRUE = 12;
	int FALSE = 13;
	int POINT = 14;
	int LEFTP = 15;
	int RIGHTP = 16;
	int LEFTC = 17;
	int RIGHTC = 18;
	int LEFTB = 19;
	int RIGHTB = 20;
	int COMMA = 21;
	int HYPHEN = 22;
	int UNDERLINING = 23;
	int ASSIGNMENT = 24;
	int MEMORY = 25;
	int VISUALPRECISION = 26;
	int VERSION = 27;
	int DEFAULT = 28;
	int NODE = 29;
	int KIND = 30;
	int OF = 31;
	int CHANCE = 32;
	int DECISION = 33;
	int UTILITY = 34;
	int TYPE = 35;
	int VARIABLE = 36;
	int RELATION = 37;
	int FINITE = 38;
	int STATES = 39;
	int POSX = 40;
	int POSY = 41;
	int CONTINUOUS = 42;
	int RELEVANCE = 43;
	int PURPOSE = 44;
	int MIN = 45;
	int MAX = 46;
	int NUM = 47;
	int PRECISION = 48;
	int TITLE = 49;
	int AUTHOR = 50;
	int WHOCHANGED = 51;
	int WHENCHANGED = 52;
	int KINDOFGRAPH = 53;
	int NUMBER = 54;
	int CASES = 55;
}
