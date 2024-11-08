/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 *
 * @author My University
 */
public class TermsAndConditions extends JFrame{
    
    public TermsAndConditions() {
        super("Terms and Conditions");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setSize(600, 400);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        //textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        String terms = """
                       TERMS AND CONDITIONS:
                       
                      1. The terms and conditions set out below are the terms and conditions of the contract between you, the sender of the Shipment and us TARA COURIER SERVICES LIMITED (hereinafter referred to as “TARA”) by your delivery of the Shipment to TARA and our receipt thereof with your delivery instructions you agree to these terms and conditions. No employee of TARA or anyone else has any authority to change any of these terms and conditions or make any promise on our behalf.
                       
                        
                       
                       2. DEFINITIONS
                       
                       (a) “Package” means any container, envelope, document or parcel that is acceptable by us for delivery
                       
                       (b) “Shipment” means all Packages that are tendered to and accepted by us for delivery and that travel hereunder under a single (Airway Bill) receipt.
                       
                        
                       
                       3. AGREEMENT TO TERMS
                       
                       By giving us your Shipment, you certify that shipment details are complete and accurate and you agree whether or not you are acting on your own behalf or as an agent for and on behalf of any other person having interest in this Shipment to all the terms and conditions hereof and to any applicable tariff.  No one is authorized to alter or modify the terms of our agreement.
                       
                        
                       
                       4. ITEMS NOT ACCEPTABLE FOR SHIPMENT
                       
                       We do not accept as a Shipment the following:-
                       
                       (a) Money/cash, or items readily convertible to money (including but not limited to coins or negotiable instruments equivalent to cash such as endorsed stocks and bonds) and jewelry
                       
                       (b) Shipments of items accepted by mistake
                       
                       (c) Items restricted by IATA (International Air Transport Association) or IAC (International Civil Organization)
                       
                       (d) Items which in our discretion we cannot transport legally or safely.
                       
                       You certify that your shipment is not restricted by any of the above limitations.
                       
                       We reserve the right to reject packages based on these limitations or for reasons of safety or security.
                       
                        
                       
                       5. YOUR OBLIGATIONS
                       
                       (a) You warrant that each article in the shipment is properly described on the Receipt/Airway Bill and any other documents acceptable and is properly marked addressed and packed to ensure safe transportation with ordinary care in handling.
                       
                       (b) You agree to pay all shipment charges and destination duties and taxes for this shipment if the receiver or third party does not pay.
                       
                       (c) You agree to pay all shipment charges including but not limited to incorrect declaration of cargo, improper or insufficient packing securing marking or addressing of the Shipment, or for the acts or omissions of the recipient or anyone else with an interest in the Shipment.
                       
                        
                       
                       6. RESPONSIBILITY FOR PAYMENT
                       
                       Regardless of your providing us with an alternative payment method or instructions, you will always be primarily responsible for all reasonable charges and possible surcharges customs and duties assessment including fees related to our prepayment of the same, governmental penalties and fines, taxes and our Attorneys Fees and legal costs related to this shipment.  You also will be responsible for any reasonable costs we incur in the shipment or warehousing of the shipment pending ultimate dispatch to you.
                       
                        
                       
                       7. DELAYED SHIPMENTS
                       
                       We will make every effort to deliver your Shipment according to our regular delivery schedules, but we are not liable for any delays in collecting a shipment, transporting a shipment (including delays caused by any diversion) and delivering a shipment occasioned by the following circumstances:-
                       
                       (a) act of God including but not limited to storm, tempest or flood;
                       
                       (b) act of war hostilities riot or civil commotion or the threat or fear of such conditions prevailing;
                       
                       (c) criminal malicious or negligent actions or acts or omissions of third parties.
                       
                       (d) industrial action or unforeseeable traffic conditions;
                       
                       (e) suspension or cancellation of transport services by reason of or of the threat or fear of inclement weather;
                       
                       (f) fire, lightning or explosion;
                       
                       (g) seizure under legal process;
                       
                       (h) your act, default or omission of whatever nature, or act, default or omission of your employees or agents or any person having any interest in the goods;
                       
                       (i) insufficient or improper packing labeling or addressing; or
                       
                       (j) the unavailability at the delivery address of the consignee or other authorized recipient.
                       
                        
                       
                       8. NO WARRANTIES
                       
                       We will make no warranties express or implied.
                       
                        
                       
                       9. LIMITATION OF LIABILITY
                       
                       Our maximum liability for loss of or damage in connection with your Shipment shall in no circumstances exceed the value of the Shipment or where you are not the owner of the Shipment then your liability to the Owner (whichever is the less).  Provided that in any case our liability is limited to J$5000.00 per shipment or
                       
                       J$1000.00 per kilogram whichever is greater.
                       
                        
                       
                       10. DECLARED VALUE & LIMITS
                       
                       You must declare a value in regard to each Shipment.  Whether or not a value is declared by you the highest declared value which will be allowed in regard to each Shipment is J$5000.00 or J$1000.00 per kilogram, whichever is greater.  If you wish TARA to accept liability for any amount in excess of the highest declared value abovementioned then you must enter into a separate contract with TARA in regard to the excess cover and pay the additional charges specified in that contract.
                       
                        
                       
                       11. LIABILITIES NOT ASSUMED
                       
                       (a) Subject to Clauses 9 & 10 above, neither TARA nor any of its servants or agents shall be liable for any loss or damages, whether direct, incidental, special or consequential in any event for any shipment given to us in excess of the amount stated in Clause 9 whether or not we knew or should have known that such damages might be incurred, including but not limited to loss of income or profits.
                       
                       (b) We will not be liable for loss of or damage to shipments of money or other prohibited items.
                       
                       (c) We will not be liable for your acts or omissions including but not limited to incorrect declaration of cargo, improper or insufficient packing, securing marking or addressing of the Shipment, or for acts or omissions of the recipient or any one else with an interest in the Shipment. Also we will not be liable if you or the recipient violates any of the terms of our agreement.  We will not be liable for loss, damage, delay, shortage, misdelivery, nondelivery, misinformation or failure to provide information in connection with Shipments of money as defined in clause 4 above or other restricted or prohibited items.
                       
                       (d) We will not be liable for loss, damage, delay, shortage, misdelivery, non-delivery, misinformation, or failure to provide information caused by events beyond our control including but not limited to acts of God, perils of the air, weather conditions, mechanical delays, acts of public enemies, war, strikes, civil commotions or acts of public authorities (including Customs or Health Officials).
                       
                        
                       
                       12. ROUTE
                       
                       The Shipment may be carried by any route at the sole discretion of TARA.
                       
                        
                       
                       13. INDEMNITY
                       
                       You shall indemnify and keep TARA harmless from and against all claims, costs and demands by whomsoever made or preferred in excess of our legal liability under these terms and conditions.
                       
                        
                       
                       14. CLAIM FOR LOSS, DAMAGE OR DELAY
                       
                       ALL CLAIMS MUST BE MADE IN WRITING AND WITHIN THE TIME LIMITS SET OUT BELOW.
                       
                       (a) The right to damages against you within the limits of clause 9 above shall be extinguished within three (3) months from the date of delivery of the Shipment or from the date on which the Shipment should have been delivered
                       
                       (b) Within 60 days of notification to us of the claim it must be documented by sending to us all relevant information about it. We are not obligated to act on any claim until all transportation charges have been paid and the claim amount may not be deducted from those charges
                       
                       (c) If the recipient accepts the Shipment without noting any damage on the delivery record we will assume that the Shipment was delivered in good condition. In order for us to consider a claim for damage, the contents, original shipping cartons and packing must be available to us for inspection.""";

        textArea.setText(terms);

        add(scrollPane);
        setVisible(true);
    }

    
       
    
}