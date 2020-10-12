package logic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
public class Controller {
	
    @FXML
    private Text output;
    private boolean start;
    private double num1;
    private String operator;
    // get Model reference
    private Model model;
    
    @FXML
    private void processNumpad(ActionEvent event) {
    	// get button number
    	if(start) {
    		output.setText("");
    		start = false;
    	}
    	String value = ((Button)event.getSource()).getText();
    	// printing in the output and updating previous output
    	output.setText(output.getText()+value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
    	// get button operator
    	String value = ((Button)event.getSource()).getText();
    	if(!"=".equals(value)) {
    		if(!operator.isEmpty()) return;
			operator = value;
			num1 = Double.parseDouble(output.getText());
			output.setText("");
  
    	} else {
    		if(operator.isEmpty()) return;
    		try {
    			output.setText(String.valueOf(model.calculate(num1, Double.parseDouble(output.getText()), operator)));
    		} catch(DivisionByZeroException|ArithmeticOverflowException ex) {
    			Alert alertBox = new Alert(AlertType.ERROR);
    	        alertBox.setHeaderText(ex.getMessage());
    	        alertBox.setContentText("click Clear button to start a new calculation");
    	        output.setText("E R R O R");
    	        alertBox.showAndWait();
    		}
			operator = "";
			start = true;
    	}
    				
    }
    
    @FXML
    private void clear(ActionEvent event) {
    	output.setText("");
    	start = true;
    	num1 = 0;
    }
    
    @FXML
    public void initialize() {
    	model = new Model();
    	output.setText("");
    	operator = "";
    	num1 = 0;
    	start = true;
    }

}
