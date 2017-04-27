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
public class S_Instruction_Bloc {
LEX_Bloc scanner;
  S_Instruction_Bloc() {
	}
  S_Instruction_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Instruction att_ast;
  LEX_Bloc att_scanner;
  private void regle9() throws Exception {

	//declaration
	S_Affectable_Bloc x_2 = new S_Affectable_Bloc(scanner,att_eval) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_4 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_9(x_2, x_4);
	x_2.analyser() ;
	x_3.analyser(LEX_Bloc.token_affectation);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_point_virgule);
if  (att_eval)	  action_ast_9(x_2, x_4);
  }
  private void regle7() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Type_Bloc x_3 = new S_Type_Bloc(scanner,att_eval) ;
	T_Bloc x_4 = new T_Bloc(scanner ) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_7(x_3, x_4);
	x_2.analyser(LEX_Bloc.token_typedef);
	x_3.analyser() ;
	x_4.analyser(LEX_Bloc.token_identificateur_type);
	x_5.analyser(LEX_Bloc.token_point_virgule);
if  (att_eval)	  action_ast_7(x_3, x_4);
  }
  private void regle70() throws Exception {

	//declaration
	S_Type_Bloc x_2 = new S_Type_Bloc(scanner,att_eval) ;
	S_NomEtendu_Bloc x_4 = new S_NomEtendu_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_6 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_7 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_70(x_2, x_4, x_6);
	x_2.analyser() ;
if  (att_eval)	  action_inh_70(x_2, x_4, x_6);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_affectation);
	x_6.analyser() ;
	x_7.analyser(LEX_Bloc.token_point_virgule);
if  (att_eval)	  action_ast_70(x_2, x_4, x_6);
  }
  private void regle18() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_4 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	T_Bloc x_6 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_18(x_4);
	x_2.analyser(LEX_Bloc.token_afficher);
	x_3.analyser(LEX_Bloc.token_parenthese_ouvrante);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_parenthese_fermante);
	x_6.analyser(LEX_Bloc.token_point_virgule);
if  (att_eval)	  action_ast_18(x_4);
  }
  private void regle17() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_4 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	S_Bloc_Bloc x_6 = new S_Bloc_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_17(x_4, x_6);
	x_2.analyser(LEX_Bloc.token_tant_que);
	x_3.analyser(LEX_Bloc.token_parenthese_ouvrante);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_parenthese_fermante);
	x_6.analyser() ;
if  (att_eval)	  action_ast_17(x_4, x_6);
  }
  private void regle14() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_4 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	S_Bloc_Bloc x_6 = new S_Bloc_Bloc(scanner,att_eval) ;
	S_SuiteConditionnelle_Bloc x_7 = new S_SuiteConditionnelle_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_14(x_4, x_6, x_7);
	x_2.analyser(LEX_Bloc.token_si);
	x_3.analyser(LEX_Bloc.token_parenthese_ouvrante);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_parenthese_fermante);
	x_6.analyser() ;
	x_7.analyser() ;
if  (att_eval)	  action_ast_14(x_4, x_6, x_7);
  }
  private void regle13() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Type_Bloc x_3 = new S_Type_Bloc(scanner,att_eval) ;
	T_Bloc x_4 = new T_Bloc(scanner ) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	S_Valeur_Bloc x_6 = new S_Valeur_Bloc(scanner,att_eval) ;
	T_Bloc x_7 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_13(x_3, x_4, x_6);
	x_2.analyser(LEX_Bloc.token_constante);
	x_3.analyser() ;
	x_4.analyser(LEX_Bloc.token_identificateur);
	x_5.analyser(LEX_Bloc.token_affectation);
	x_6.analyser() ;
	x_7.analyser(LEX_Bloc.token_point_virgule);
if  (att_eval)	  action_1_13(x_3, x_4, x_6);
  }
private void action_auto_inh_9(S_Affectable_Bloc x_2, S_Expression_Bloc x_4) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
x_2.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> Affectable affectation Expression point_virgule #ast ;", e });
}
  }
private void action_auto_inh_7(S_Type_Bloc x_3, T_Bloc x_4) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> typedef Type identificateur_type point_virgule #ast ;", e });
}
  }
private void action_ast_70(S_Type_Bloc x_2, S_NomEtendu_Bloc x_4, S_Expression_Bloc x_6) throws Exception {
try {
// locales
VariableDeclaration loc_v;
// instructions
if (this.att_tds.contains(x_4.att_nom)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IBlocMessages.id_BLOC_already_defined, BlocMessages.BLOC_already_defined,new Object[]{""+x_4.att_nom});

}
else {
loc_v=this.att_factory.createVariableDeclaration(x_4.att_nom, x_4.att_ast, x_6.att_ast);
this.att_tds.register(loc_v);
this.att_ast=loc_v;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Instruction -> Type #inh NomEtendu affectation Expression point_virgule #ast ;", e });
}
  }
private void action_1_13(S_Type_Bloc x_3, T_Bloc x_4, S_Valeur_Bloc x_6) throws Exception {
try {
// locales
ConstantDeclaration loc_d;
// instructions
if (this.att_tds.contains(x_4.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IBlocMessages.id_BLOC_identifiant_constante_deja_utilise, BlocMessages.BLOC_identifiant_constante_deja_utilise,new Object[]{""+x_4.att_txt});

}
else {
loc_d=this.att_factory.createConstantDeclaration(x_4.att_txt, x_3.att_ast, x_6.att_ast);
this.att_tds.register(loc_d);
this.att_ast=loc_d;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#1","Instruction -> constante Type identificateur affectation Valeur point_virgule #1 ;", e });
}
  }
private void action_auto_inh_17(S_Expression_Bloc x_4, S_Bloc_Bloc x_6) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_4.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> tant_que parenthese_ouvrante Expression parenthese_fermante Bloc #ast ;", e });
}
  }
private void action_auto_inh_18(S_Expression_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> afficher parenthese_ouvrante Expression parenthese_fermante point_virgule #ast ;", e });
}
  }
private void action_ast_9(S_Affectable_Bloc x_2, S_Expression_Bloc x_4) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createAssignment(x_2.att_ast, x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Instruction -> Affectable affectation Expression point_virgule #ast ;", e });
}
  }
private void action_ast_14(S_Expression_Bloc x_4, S_Bloc_Bloc x_6, S_SuiteConditionnelle_Bloc x_7) throws Exception {
try {
// instructions
if (((x_7.att_ast==null))){
this.att_ast=this.att_factory.createConditional(x_4.att_ast, x_6.att_ast);
}
else {
this.att_ast=this.att_factory.createConditional(x_4.att_ast, x_6.att_ast, x_7.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Instruction -> si parenthese_ouvrante Expression parenthese_fermante Bloc SuiteConditionnelle #ast ;", e });
}
  }
private void action_ast_17(S_Expression_Bloc x_4, S_Bloc_Bloc x_6) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createRepetition(x_4.att_ast, x_6.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Instruction -> tant_que parenthese_ouvrante Expression parenthese_fermante Bloc #ast ;", e });
}
  }
private void action_ast_18(S_Expression_Bloc x_4) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createPrinter(x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Instruction -> afficher parenthese_ouvrante Expression parenthese_fermante point_virgule #ast ;", e });
}
  }
private void action_ast_7(S_Type_Bloc x_3, T_Bloc x_4) throws Exception {
try {
// locales
TypeDeclaration loc_v;
// instructions
if (this.att_tds.contains(x_4.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IBlocMessages.id_BLOC_identifiant_variable_deja_utilise, BlocMessages.BLOC_identifiant_variable_deja_utilise,new Object[]{""+x_4.att_txt});

}
else {
loc_v=this.att_factory.createTypeDeclaration(x_4.att_txt, x_3.att_ast);
this.att_tds.register(loc_v);
this.att_ast=loc_v;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Instruction -> typedef Type identificateur_type point_virgule #ast ;", e });
}
  }
private void action_auto_inh_13(S_Type_Bloc x_3, T_Bloc x_4, S_Valeur_Bloc x_6) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> constante Type identificateur affectation Valeur point_virgule #1 ;", e });
}
  }
private void action_auto_inh_14(S_Expression_Bloc x_4, S_Bloc_Bloc x_6, S_SuiteConditionnelle_Bloc x_7) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_7.att_factory=this.att_factory;
x_4.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
x_7.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> si parenthese_ouvrante Expression parenthese_fermante Bloc SuiteConditionnelle #ast ;", e });
}
  }
private void action_auto_inh_70(S_Type_Bloc x_2, S_NomEtendu_Bloc x_4, S_Expression_Bloc x_6) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
x_2.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instruction -> Type #inh NomEtendu affectation Expression point_virgule #ast ;", e });
}
  }
private void action_inh_70(S_Type_Bloc x_2, S_NomEtendu_Bloc x_4, S_Expression_Bloc x_6) throws Exception {
try {
// instructions
x_4.att_type=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inh","Instruction -> Type #inh NomEtendu affectation Expression point_virgule #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_typedef : // 66
        regle7 () ;
      break ;
      case LEX_Bloc.token_identificateur : // 70
        regle9 () ;
      break ;
      case LEX_Bloc.token_parenthese_ouvrante : // 34
        regle9 () ;
      break ;
      case LEX_Bloc.token_multiplication : // 48
        regle9 () ;
      break ;
      case LEX_Bloc.token_constante : // 63
        regle13 () ;
      break ;
      case LEX_Bloc.token_si : // 55
        regle14 () ;
      break ;
      case LEX_Bloc.token_tant_que : // 58
        regle17 () ;
      break ;
      case LEX_Bloc.token_afficher : // 57
        regle18 () ;
      break ;
      case LEX_Bloc.token_type_bool : // 62
        regle70 () ;
      break ;
      case LEX_Bloc.token_type_int : // 61
        regle70 () ;
      break ;
      case LEX_Bloc.token_inferieur : // 36
        regle70 () ;
      break ;
      case LEX_Bloc.token_identificateur_type : // 71
        regle70 () ;
      break ;
      case LEX_Bloc.token_enregistrement : // 64
        regle70 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
