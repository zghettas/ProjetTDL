package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_SuiteNouveau_Bloc {
LEX_Bloc scanner;
  S_SuiteNouveau_Bloc() {
	}
  S_SuiteNouveau_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expression att_ast;
  LEX_Bloc att_scanner;
  Type att_type;
  private void regle64() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_3 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_4 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_64(x_3);
	x_2.analyser(LEX_Bloc.token_crochet_ouvrant);
	x_3.analyser() ;
	x_4.analyser(LEX_Bloc.token_crochet_fermant);
if  (att_eval)	  action_ast_64(x_3);
  }
  private void regle65() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_65();
  }
private void action_auto_inh_64(S_Expression_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","SuiteNouveau -> crochet_ouvrant Expression crochet_fermant #ast ;", e });
}
  }
private void action_ast_64(S_Expression_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createArrayAllocation(this.att_type, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","SuiteNouveau -> crochet_ouvrant Expression crochet_fermant #ast ;", e });
}
  }
private void action_ast_65() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createPointerAllocation(this.att_type);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","SuiteNouveau -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_crochet_ouvrant : // 32
        regle64 () ;
      break ;
      case LEX_Bloc.token_multiplication : // 48
        regle65 () ;
      break ;
      case LEX_Bloc.token_division : // 49
        regle65 () ;
      break ;
      case LEX_Bloc.token_modulo : // 50
        regle65 () ;
      break ;
      case LEX_Bloc.token_et : // 52
        regle65 () ;
      break ;
      case LEX_Bloc.token_addition : // 45
        regle65 () ;
      break ;
      case LEX_Bloc.token_soustraction : // 46
        regle65 () ;
      break ;
      case LEX_Bloc.token_ou : // 47
        regle65 () ;
      break ;
      case LEX_Bloc.token_egalite : // 44
        regle65 () ;
      break ;
      case LEX_Bloc.token_different : // 65
        regle65 () ;
      break ;
      case LEX_Bloc.token_inferieur : // 36
        regle65 () ;
      break ;
      case LEX_Bloc.token_inferieur_egal : // 38
        regle65 () ;
      break ;
      case LEX_Bloc.token_superieur : // 37
        regle65 () ;
      break ;
      case LEX_Bloc.token_superieur_egal : // 39
        regle65 () ;
      break ;
      case LEX_Bloc.token_crochet_fermant : // 33
        regle65 () ;
      break ;
      case LEX_Bloc.token_point_virgule : // 41
        regle65 () ;
      break ;
      case LEX_Bloc.token_parenthese_fermante : // 35
        regle65 () ;
      break ;
      case LEX_Bloc.token_virgule : // 42
        regle65 () ;
      break ;
      case LEX_Bloc.token_accolade_fermante : // 31
        regle65 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
