/*
 *  Rahul Sharma
    2/14/15
    IT 206-001
    Assignment 2-IMPLEMENTATION CLASS
 * DESCRIPTION: This application is used to keep track of donations made towards projects.
 * First off, the user is asked for the name of the project, whether the project has a sponsor 
 * or not. Then, the program asks the user if they want to use the default target amount of 1000.
 * If the user's reply is no, then the user is asked for the desired target amount. If the project
 * has an sponsor, each donation entered by the user is doubled. Next, the user is prompted for 
 * donation amount until the user has indicated that he/she doesn't want to make any more donations 
 * or until all the donations made are less than the target amount or if there is a sponsor, the 
 * donations made are less than half of the target amount. After all the donations have been entered,
 * a report consisting of the project name, number of donations, the total donation, the target 
 * amount and whether the project has a sponsor or not. 
 */import javax.swing.JOptionPane;
public class ProjectDonations {
     
    public static void main(String[] args) {
 
        String projName = getProjectName(); 
        int hasSponsor = getSponsorOrNot(projName);
        int targetOrNot = getTargetOrNot();
        double targetAmt =0;
        final double LOWEST_VAL = 0.0;
        double donationAmt = 0;
        int continueOrNot;
        Project myProject;
         
        /*if the user wants to use the default target amount, an object with the name of myProject 
         * is created with the default constructor that will set the target amount to 1000.
         * If the user doesn't want to use the default, then the user is asked for the target amount.
         * Then an object called myProject is created with the specific constructor that accepts the 
         * amount from the user and sets it to target amount
         */
         
        if(targetOrNot == JOptionPane.YES_OPTION){
            myProject = new Project();
        }
        else{
            do{ 
                targetAmt = getTargetAmt();
            }while(targetAmt <= LOWEST_VAL);
            myProject = new Project(targetAmt);
        }
        //setProjectName is called to set the name of the project in the DD(data definition class)
        myProject.setProjectName(projName);
        //setCorpSponsor is called to set whether the project has a sponsor or not in the DD(data definition class)
        myProject.setCorpSponsor(hasSponsor);
             
         
        //the user is asked to enter donations till he/she indicates there aren't no donations to enter
        do{
            //the user is asked for donation amount till its more than 0
            do{
                donationAmt = getDonationAmt();
            }while(donationAmt <= LOWEST_VAL);
             
            //the user is asked for the donation amount if the donation amount goes over the target amount
            while(myProject.setDonationAmt(donationAmt)==false){
                JOptionPane.showMessageDialog(null, "You have exceded the target amount");
                donationAmt = getDonationAmt();
            }
            continueOrNot = (myProject.getTargetAmt()>myProject.getDonationAmt())? JOptionPane.showConfirmDialog(null,"Do you have MORE DONATIONS to enter?"): JOptionPane.NO_OPTION;
             
        }while(continueOrNot == JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null, myProject.toString());
    }
     
    /*
    Method Name:    getDonationAmt
    Purpose:        This method asks for a donation amount
    Return Value:   (double) donationAmt
    Parameters:     none
    */
    private static double getDonationAmt() {
        double donationAmt = 0;
        try{
             donationAmt =  Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the DONATION amount. It must be more than 0"));
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"ERROR!!!!The donation amount must be numeric. PLEASE RE-ENTER");
        }
        return donationAmt;
    }
 
    /*
    Method Name:    getTargetAmt
    Purpose:        This method asks for the target amount
    Return Value:   (double) targetAmt
    Parameters:     none
    */
    private static double getTargetAmt() {
        double targetAmt = 0;
        try{
            targetAmt = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the TARGET amount. IT must be more than 0"));           
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"ERROR!!!!The target cost must be numeric. PLEASE RE-ENTER");
        }       
        return targetAmt;
    }
 
    /*
    Method Name:    getProjectName
    Purpose:        This method asks for the name of the project
    Return Value:   (String) projName
    Parameters:     none
    */
    private static String getProjectName(){
        String projName = JOptionPane.showInputDialog(null,"Enter the PROJECT NAME "); 
        return projName;
    }
     
    /*
    Method Name:    getSponsor
    Purpose:        This method asks whether the project has an sponsor or not
    Return Value:   (int) hasSponsor
    Parameters:     (String) projName
    */
    private static int getSponsorOrNot(String projName){
        int hasSponsor = JOptionPane.showConfirmDialog(null,"Does the project " + projName.toUpperCase() +" have a SPONSOR?"); 
        return hasSponsor;
    }
     
    /*
    Method Name:    getTargetOrNot
    Purpose:        This method asks whether to use the default target amount or not
    Return Value:   (int) targetOrNot
    Parameters:     none
    */
    private static int getTargetOrNot(){
        int targetOrNot = JOptionPane.showConfirmDialog(null,"Do you want to use the DEFAULT TARGET AMOUNT?");
        return  targetOrNot;
    }
}