/**
 * 
 */
/**
 * @author Krzysiek
 *
 */
module PROZ_Project_2 {
	requires transitive javafx.controls;
	//requires jdk.jshell;
	requires javafx.fxml;
	requires javafx.graphics;
	exports controller to view;
	exports main;
	exports model to controller;
	opens controller to javafx.fxml;
}