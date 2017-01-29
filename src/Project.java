/*
 *  Rahul Sharma
    2/14/15
    IT 206-001
    Assignment 2-DATA DEFENITION CLASS
 * This class will store the name of the project, the target total amounts of donations desired, 
 * the actual amount of donations received and if the project has a corporate sponsor or not
 * and the number of donations made for the project
 */
import javax.swing.JOptionPane;
 
public class Project {
 
    private String projectName;
    private double targetAmt;
    private double totalDonationAmt;
    private boolean hasCorpSponsor;
    private double maxInput;
    private int numOfDonations;
     
    //the default constructor that sets the targetAmt to 1000
    public Project(){
        final int DEFAULT_TARGET_AMT = 1000;
        targetAmt = DEFAULT_TARGET_AMT;
        maxInput = DEFAULT_TARGET_AMT;
    }
     
    //the specific constructor that sets the targetAmt to the amount the user desires
    public Project(double targetAmtInput){
        targetAmt = targetAmtInput;
        maxInput = targetAmt;
    }
     
    /*
    Method Name:    setDonationAmt
    Purpose:        This method sets the projectName to projectNameInput(the value sent in from the implementation class)
    Return Value:   void
    Parameters:     (String) projectNameInput
    */
    public void setProjectName(String projectNameInput){
        projectName = projectNameInput;
    }
     
    /*
    Method Name:    setCorpSponsor
    Purpose:        This method sets whether there is a sponsor or not(based on the value sent in from the implementation class)
    Return Value:   void
    Parameters:     (String) projectNameInput
    */
    public void setCorpSponsor(int hasSponsor){
        hasCorpSponsor = (hasSponsor == JOptionPane.YES_OPTION)? true : false; 
    }
     
    /*
    Method Name:    setDonationAmt
    Purpose:        This method checks if the donation amount from the implementation class is more than the target amount.
                    If so, the value false is returned. Else if there is a sponsor, the donation amount is doubled and added
                    to the total donation amount. If there isn't a sponsor, the donation amount is added to the total donation
                    amount. Then the number of donations is incremented by 1 and a true value is returned. 
    Return Value:   (boolean) set
    Parameters:     (double) userDonationAmt
    */
    public boolean setDonationAmt(double userDonationAmt){
        final int SPONSOR_RATE = 2;
        if(((userDonationAmt> maxInput) && (hasCorpSponsor==false))|| ((hasCorpSponsor==true ) &&((userDonationAmt* SPONSOR_RATE)> maxInput ))) {
            return false;
        }
        else if(hasCorpSponsor){
            maxInput -= userDonationAmt*SPONSOR_RATE;
            addDonation(userDonationAmt*SPONSOR_RATE);
            numOfDonations++;
            return true;    
        }
        else{
            maxInput -= userDonationAmt;
            addDonation(userDonationAmt);   
            numOfDonations++;
            return true;
        }
    }
     
    /*
    Method Name:    addDonation
    Purpose:        This method adds the userDonationAmt to totalDonationAmt to keep track of all the donations that
                    have been entered
    Return Value:   void
    Parameters:     (double) userDonationAmt
    */
    public void addDonation(double userDonationAmt) {
        totalDonationAmt+=userDonationAmt;
    }
     
    /*
    Method Name:    getNumOfDonations
    Purpose:        This method returns the numOfDonations 
    Return Value:   (int) numOfDonations
    Parameters:     none
    */
    public int getNumOfDonations(){
        return numOfDonations;
    }
     
    /*
    Method Name:    getProjectName
    Purpose:        This method returns the projectName 
    Return Value:   (String) projName
    Parameters:     none
    */
    public String getProjectName(){
        return projectName;
    }
     
    /*
    Method Name:    getCorpSponsor
    Purpose:        This method returns the hasCorpSponsor 
    Return Value:   (boolean) hasCorpSponsor
    Parameters:     none
    */
    public boolean getCorpSponsor(){
        return hasCorpSponsor;
    }
     
    /*
    Method Name:    getTargetAmt
    Purpose:        This method returns the targetAmt 
    Return Value:   (double) targetAmt
    Parameters:     none
    */
    public double getTargetAmt(){
        return targetAmt;
    }
     
    /*
    Method Name:    getDonationAmt
    Purpose:        This method returns the total Donation amount
    Return Value:   (double) totalDonationAmt
    Parameters:     none
    */
    public double getDonationAmt(){
        return totalDonationAmt;
    }
     
    /*
    Method Name:    toString
    Purpose:        This method returns a message consisting of project name, total number of donations, target amount,
                    total donation amount, whether the project has a sponsor or not(true or false)
    Return Value:   (String) message
    Parameters:     none
    */
    public String toString(){
        String message = "The name of the project is : "+ projectName.toUpperCase()+"\n"
                +"The number of donations are : "+ numOfDonations+"\n"
                +"The total amount of donations desired are : "+ targetAmt+"\n"
                +"The amount of donations recieved are : " + totalDonationAmt+"\n"
                +"The project has a sponsor? " + hasCorpSponsor;
        return message;
    }
}