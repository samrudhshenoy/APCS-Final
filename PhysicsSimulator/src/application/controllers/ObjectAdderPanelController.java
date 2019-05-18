package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/** The class that controls the sidebar that can be used for actions or adding new obstacles
 * 
 * @author samarthshah
 *
 */
public class ObjectAdderPanelController {
	
	private MainScreenController m;
	
	@FXML TextField xField;
	@FXML TextField yField;
	@FXML TextField angleField;
	@FXML TextField lengthField;

	/**
	 * 
	 * @param main The main screen controller is controls the sidebar
	 */
	public void setController(MainScreenController main) {
		m = main;
	}
	
	/** Handles what to do if the add button is pressed
	 * 
	 * @param event
	 */
	@FXML
    void handleAdd(ActionEvent event) {
		if (isInputValid()) {
			double x = Double.parseDouble(xField.getText());
			double y = Double.parseDouble(yField.getText());
			double angle = Double.parseDouble(angleField.getText());
			double length = Double.parseDouble(lengthField.getText());
			m.addNewObstacle(x, y, angle, length);

		}
	}
	
	/** Pauses the simulation when the button is pressed
	 * 
	 * @param event
	 */
	@FXML
	void handlePause(ActionEvent event) {
		m.pause();
	}
	
	/** Plays the simulation when the button is pressed
	 * 
	 * @param event
	 */
	@FXML
	void handlePlay(ActionEvent event) {
		m.play();
	}
	
	/** Goes back to the main menu when the button is pressed
	 * 
	 * @param event
	 */
	@FXML
	void handleBack(ActionEvent event) {
		m.getMain().showMenuScreen();
	}
	
	/** Resets the obstacles when the button is pressed
	 * 
	 * @param event
	 */
	@FXML
	void handleReset(ActionEvent event) {
		m.getWorld().resetObstacles();
	}


	/** 
	 * 
	 * @return True if the inputs in the fields are valid for creating a new obstacle
	 */
	public boolean isInputValid() {
		String errorMessage = "";

		if(xField.getText() == null || xField.getText().length() == 0) {
			errorMessage += "No valid x!\n";
		} else{
			try{
				Double.parseDouble(xField.getText());
			} catch (NumberFormatException e){
				errorMessage += "No valid x!\n";
			}
		}
		
		if(yField.getText() == null || yField.getText().length() == 0) {
			errorMessage += "No valid grade!\n";
		} else{
			try{
				Double.parseDouble(yField.getText());
			} catch (NumberFormatException e){
				errorMessage += "No valid grade!\n";
			}
		}
		
		if(angleField.getText() == null || angleField.getText().length() == 0) {
			errorMessage += "No valid x!\n";
		} else{
			try{
				Double.parseDouble(angleField.getText());
			} catch (NumberFormatException e){
				errorMessage += "No valid x!\n";
			}
		}
		
		if(lengthField.getText() == null || lengthField.getText().length() == 0) {
			errorMessage += "No valid grade!\n";
		} else{
			try{
				Double.parseDouble(lengthField.getText());
			} catch (NumberFormatException e){
				errorMessage += "No valid grade!\n";
			}
		}
		
		

		//if there is no error message, returns true
		if (errorMessage.length() == 0) {
			return true;
		} else { //if there is an error message, create alert with error messages printed
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.initOwner(s);
//			alert.setTitle("Invalid Fields");
//			alert.setHeaderText("Please correct invalid fields");
//			alert.setContentText(errorMessage);
//			alert.showAndWait();

			return false;
		}
	}
    

}
