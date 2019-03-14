/*
      Jameson Price, 02-12-2018
	  This is a small project to practice and utilize different regexes for user input.
*/

import java.util.regex.*;
import java.util.Scanner;

public class myReg
{
   public static void main(String args[])
   {
      int n = 0;
      Scanner kb = new Scanner(System.in);
      String input = "";
      while(input.compareTo("q")!= 0)
      {
         menu();
         System.out.println("Choose menu option: ");
         input = kb.nextLine();
         System.out.println("Enter input: ");
         switch(input)
         {
            case "a": input = kb.nextLine();
                      socialSecRegex(input);
                      break;
            case "b": input = kb.nextLine();
                      phoneRegex(input);
                    break;
            case "c": input = kb.nextLine();
                      emailRegex(input);
                    break;
            case "d": input = kb.nextLine();
                      fullNameRegex(input);
                    break;
            case "e": input = kb.nextLine();
                      dateRegex(input);
                    break;
            case "f": input = kb.nextLine();
                      addressRegex(input);
                    break;
            case "g": input = kb.nextLine();
                      cityStateZipRegex(input);
                    break;
            case "h": input = kb.nextLine();
                      militaryRegex(input);
                    break;
            case "i": input = kb.nextLine();
                      currencyRegex(input);
                    break;
            case "j": input = kb.nextLine();
                      urlRegex(input);
                    break;
            case "k": input = kb.nextLine();
                      passwordRegex(input);
                    break;
            case "l": input = kb.nextLine();
                      oddIonWordsRegex(input);
                    break;
            case "q": System.out.println("q\n");
                    break;
            default: System.out.println("Invalid Menu entry\n");
                    break;
         }
         n = n + 2;
      }
   }
   
   public static void menu()
   {
      System.out.println("a. Social Security Number\n");
      System.out.println("b. US Phone Number\n");
      System.out.println("c. E-mail address\n");
      System.out.println("d. Name on a class roster, assuming one or more middle initials - Last Name, First Name, MI\n");
      System.out.println("e. Date in MM-DD-YYYY format\n");
      System.out.println("f. House address - street number, street name, abbreviation for road, street, boulevard or avenue\n");
      System.out.println("g. City followed by state followed by zip as it should appear on a letter\n");
      System.out.println("h. Military time, including seconds\n");
      System.out.println("i. US Currency down to the penny (ex: $123,456,789.23)\n");
      System.out.println("j. URL, including http:// (upper and lower case should be accepted\n");
      System.out.println("k. A password that contains at least 10 characters and includes at least one upper case character, lower case character, digit, punctuation mark, and does not have more than 3 consecutive lower case characters\n");
      System.out.println("l. All words containing an odd number of alphabetic characters, ending in \"ion\"");
      System.out.println("q. quit\n");
   }
   
   /*
         SSN REGEX
         
      \\d{3} This takes the first 3 digits of the SSN
      ([\\-]?)([( )]?) This allows an optional dash or a single optional space
      \\d{2} This takes the next 2 digits of the SSN
      ([\\-]?)([( )]?) This allows an optional dash or a single optional space
      \\d{4} This takes the last 4 digits of the SSN
      Valid input;
         123456789
         123-45-6789
         12345-6789
         123-456789
         123 45 6789
         12345 6789
         123 456789
      Invalid input;
         1234567890
         1-2-3-4-5-6-7-8-9
         1 2 3 4 5 6 7 8 9
         123           45           6789
   */
   public static void socialSecRegex(String input)//complete
   {
      boolean match = Pattern.compile("^(\\d{3}([\\-]?)([( )]?)\\d{2}([\\-]?)([( )]?)\\d{4})$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
            PHONE REGEX
            
      ([1]?([\\-]?) This allows an optional leading 1 and an optional -
      ([\\(])?(\\d{3})([\\)])?)? This allows an optional area code with optional parenthesis
       ([\\-]?) This allows an optional -
       \\d{3} This takes the first 3 digits of the phone number
       ([\\-]?) This allows for an optional -
       \\d{4} This takes the last 4 digits of the phone number
       Valid input;
         18001234567
         1-800-123-4567
         1-800-1234567
         1-(800)-1234567
         1(800)1234567
         1800-1234567
      Invalid input;
         1 800 123 4567
         123 4567
         180012345678
   */
   public static void phoneRegex(String input)//complete
   {
      boolean match = Pattern.compile("^(([1]?([\\-]?)([\\(])?(\\d{3})([\\)])?)?([\\-]?)\\d{3}([\\-]?)\\d{4})$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
            EMAIL REGEX
            
      ([a-z]|[A-Z]|[0-9]) This enforces at least 1 non . or _ character before the @ symbol
      ([a-z]|[A-Z]|[0-9]|[\\.]|[\\_])+ This allows for any extra characters beyond the first including .'s and _'s
      ([\\@]) This enforces the @ symbol in the input
      ([a-z]|[A-Z]|[0-9]) This enforces at least 1 non . or _ character after the @ symbol
      ([a-z]|[A-Z]|[0-9]|[\\.]|[\\_])+ This allows for any characters after the @ symbol
      (com|net|org|gov|co|edu|biz|info|tv|eu|uk) This enforces common ending domains for the email
      Valid input;
         jamesonhp95@eagles.ewu.edu
         jamesonhp95@ewu.edu
         jamesonhp.95@comcast.net
         jamesonhp_95@hotmail.com
      Invalid input;
         jame son95@eagles.ewu.edu
         jamesonhp95@edu
         jamesonhp95@.com
   */
   public static void emailRegex(String input)//complete
   {
      boolean match = Pattern.compile("^([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|[\\.]|[\\_])+([\\@])([a-z]|[A-Z]|[0-9])([a-z]|[A-Z]|[0-9]|[\\.]|[\\_])+(com|net|org|gov|co|edu|biz|info|tv|eu|uk)$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
               NAME REGEX
               
      ([a-z]|[A-Z]|[\\-])+) This allows for any amount of characters including hyphenated last names
      ([\\,]|( )|[\\,]( )) This enforces either a comma, a space, or a comma and a space as a deliminator
      ([a-z]|[A-Z]|[\\-])+) This allows for any amount of characters including hyphenated first names
      ([\\,]|( )|[\\,]( )) This enforces either a comma, a space, or a comma and a space as a deliminator
      ([a-z]|[A-Z]) This enforces at least one middle initial
      ((([( )]|[\\,]|[\\,][( )])([a-z]|[A-Z]))?)+) This allows for optional extra middle initials, so long as they are deliminated by a comma, or a space, or a comma and a space
      Valid input;
      price, jameson, h
      price jameson h
      price-mcmurtry jameson-aric h
      price-mcmurtry, jameson-aric, h
      price, jameson, h, k, l
      Invalid input;
      pr  ice, ja   meson, hhhh
      price, jameson, h( ) --- The name must end with a middle initial, cannot have a tailing space 
   */
   public static void fullNameRegex(String input)//complete
   {
      boolean match = Pattern.compile("^((([a-z]|[A-Z]|[\\-])+)([\\,]|( )|[\\,]( ))(([a-z]|[A-Z]|[\\-])+)([\\,]|( )|[\\,]( ))([a-z]|[A-Z])((([( )]|[\\,]|[\\,][( )])([a-z]|[A-Z]))?)+)$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
               DATE REGEX
                  
      ([0]?[1-9]|[1][0-2]) This allows for the month, in the format of 01-12 with an optional leading 0
      ([\\-]|[( )]|[/]) This allows for either a dash, space, or forward slash as the deliminator between the month and the day
      ([0]?[1-9]|[1-2][1-9]|[3][1]) This allows for the day, in the format of 01-31 with an optional leading 0
      ([\\-]|[( )]|[/]) This allows for either a dash, space, or forward slash as the deliminator between the day and the year
      ([0]?[1-3]?[0-9][0-9][0-9]) This allows for the year, in the format of XXXX with an optional leading 0 in the case of the year 999 for example. However, this does not allow for just 99 as the year, it would
                                                                                                                                                   Have to be input as 099 for the year 99
      Then I have an if-else block after checking if the input matches my regex, meaning it is of the previous format. Then, if I have month 4,6,9, or 11 and I have 31 days, I report to the user that the date is 
      not a match. Then I check if the month is 2, if it is, I compare the year%4, year%100, and year%400 to determine if it is a leap year, then based on that I determine if the date is valid depending on if they put a 29 or 28
      Valid input;
      01-11-1995
      01/11/1995
      01 11 1995
      1 11 1995
      Invalid input
      01-40-2000
      02-29-2018
      0 2 - 2 2 - 1 2 2 2
   */
   public static void dateRegex(String input)//complete
   {
      Matcher myMatch = Pattern.compile("^([0]?[1-9]|[1][0-2])([\\-]|[( )]|[/])([0]?[1-9]|[1-2][1-9]|[3][1])([\\-]|[( )]|[/])([0]?[1-3]?[0-9][0-9][0-9])$").matcher(input);
      boolean match = myMatch.matches();
      if(match){
         int year = Integer.parseInt(myMatch.group(5));
         String month = myMatch.group(1);
         String day = myMatch.group(3);
         myMatch.reset();
         if(myMatch.find())
         {
            if(day.equals("31") && month.equals("4") || month.equals("04") || month.equals("6") || month.equals("06") || month.equals("9") || month.equals("09") || month.equals("11"))
               System.out.println("No Match\n");
            else if(month.equals("2") || month.equals("02"))
            {
               if((year %4 == 0 && year %100 !=0) || year % 400 == 0)
               {
                  if(day.equals("30") || day.equals("31"))
                     System.out.println("No Match\n");
                  else
                     System.out.println("Matches!\n");
               }
               else
               {
                  if(day.equals("29") || day.equals("30") || day.equals("31"))
                     System.out.println("No Match\n");
                  else
                     System.out.println("Matches!\n");
               }
            }
            else
               System.out.println("Matches!\n");
         }
         else
            System.out.println("No Match\n");
      }
      else
         System.out.println("No Match.\n");
   }
   
   /*
               ADDRESS REGEX
                  
      [1-9] This enforces at least one leading number for the street number
      [0-9]+)? This allows for any amount of following numbers after the first number for street number
      [\\,]([( )]? This allows for comma separated with an optional space after the comma
      ([a-z]|[A-Z])+) This allows for any amount of letters after the deliminator, with a minimum of one letter due to the + symbol
      [\\,]([( )]? This allows for comma separated with an optional space after the comma
      (rd|RD|Rd|rD|road|Road|ROAD)|(st|ST|sT|St|street|Street|STREET)|(ave|AVE|Ave|AVENUE|Avenue|avenue)|(blvd|BLVD|Blvd|BOULEVARD|Boulevard|boulevard)) This enforces at least one of the street types, Rd, St, Ave, or Blvd
      Valid input;
      123, Faraway, Rd
      123, Northway, AVE
      123, Neverland, Boulevard
      124, westland, STREET
      Invalid input;
      123 Faraway Rd
      123, Northway, aVE
      1 2 3, Neverland, b
   */
   public static void addressRegex(String input)//complete
   {
      boolean match = Pattern.compile("^([1-9]([0-9]+)?)([\\,]([( )]?)(([a-z]|[A-Z])+)([\\,]([( )])?)((rd|RD|Rd|rD|road|Road|ROAD)|(st|ST|sT|St|street|Street|STREET)|(ave|AVE|Ave|AVENUE|Avenue|avenue)|(blvd|BLVD|Blvd|BOULEVARD|Boulevard|boulevard)))$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
               CITY-STATE-ZIP REGEX
               
      ([a-z]|[A-Z])+) This accepts one or more character, upper or lower case as the city
      ([( )]|[\\,]|[\\,][( )]) This allows the user to deliminate by either a comma, or a comma and a space
      (?i)(AL|AK|AZ|AR|CA|CO|CT|DE|FL|GA|HI|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY) This enforces that the user will choose a valid state, case insensitive
      ([( )]|[\\,]|[\\,][( )]) This allows the user to deliminate by either a comma, or a comma and a space
      (\\d{5}) This allows for 5 digits as the zip code, no more or less since a zip code is always 5 digits
      Valid input;
      spokane, WA, 99223
      Cheney, wa, 99005
      New York, NY, 99112
      Invalid input
      New York NY 99112
      new york new york 99112
      NotReal BD 01
   */
   public static void cityStateZipRegex(String input)//complete
   {
      boolean match = Pattern.compile("^(([a-z]|[A-Z]|[( )])+)([\\,]|[\\,][( )])((?i)(AL|AK|AZ|AR|CA|CO|CT|DE|FL|GA|HI|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY))([\\,]|[\\,][( )])(\\d{5})$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
            MILITARY REGEX
            
   ([0-1][0-9]([\\:]?)[0-5][0-9]) This allows for the HH:MM portion of military time between 00-19 hours and 00-59 minutes, with an optional colon
   ([2][0-3]([\\:])?[0-5][0-9]) This allows for the HH:MM portion of military time bewteen 20-23 hours and 00-59 minutes, with an optional colon
   ([2][4]([\\:])?[0][0]) This allows for the HH:MM portion of military time, exactly for 24 hours and 00 minutes, with an optional colon
   ([\\:][0-5][0-9])?) This allows for an optional SS portion of military time, with an enforced colon only for the seconds
   Valid input;
   12:53
   1253
   1800
   1800:05
   20:10:15
   Invalid input;
   125302
   1 2 3 4 5 6
   1-2-3-4-5-6
   */
   public static void militaryRegex(String input)//complete
   {
      boolean match = Pattern.compile("^(((([0-1][0-9]([\\:]?)[0-5][0-9])|([2][0-3]([\\:])?[0-5][0-9])|([2][4]([\\:])?[0][0]))([\\:][0-5][0-9])?))$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
            CURRENCY REGEX
            
      ([\\$]?) This allows for an optional leading $ sign
      ([0-9]?[0-9]?[0-9]?) This allows for three optional digits
      [\\,]?[0-9][0-9][0-9])+)? This allows for an optional comma between hundreds, thousands, millions, billions, etc and any amount of digits afterwards in sets of three
                                                                                                                        This is ok to be sets of three because our previous three numbers are optional
      ([\\.][0-9][0-9])?) This allows for an optional period and pennies onto our currency
      Valid input;
      12,300
      $12,300
      $12,300.25
      12300
      Invalid input;
      $ 12 300.25
      12-300-25
   */
   public static void currencyRegex(String input)//complete
   {
      boolean match = Pattern.compile("^(([\\$]?)([0-9]?[0-9]?[0-9]?)(([\\,]?[0-9][0-9][0-9])+)?([\\.][0-9][0-9])?)$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
               URL REGEX
               
      ([h]|[H])([t]|[T])([t]|[T])([p]|[P])(([s]|[S])?)(:\\/\\/))([w]|[W])([w]|[W])([w]|[W]) This enforces http://www or https://www case insensitive
      ([a-z]|[A-Z]|[0-9]|[\\.]|[\\_]|[\\-])+ This allows for any letter, number, period, underscore, or dash throughout the url
      ([\\.])(com|net|gov|uk|co|edu|eu|biz) This enforces a period and a common domain ending to tail the url
      Valid input;
      http://www.ewu.edu
      https://www.facebook-fishing-attempt.com
      HTTP://WWW.CANVAS.EWU.EDU
      Invalid input;
      www.ewu.edu
      ewu.edu
      http://www.canvas.fake
   */
   public static void urlRegex(String input)//complete
   {
      boolean match = Pattern.compile("^((([h]|[H])([t]|[T])([t]|[T])([p]|[P])(([s]|[S])?)(:\\/\\/))([w]|[W])([w]|[W])([w]|[W])([\\.])([a-z]|[A-Z]|[0-9]|[\\.]|[\\_]|[\\-])+([\\.])((?i)(com|net|gov|uk|co|edu|eu|biz)))$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
            PASSWORD REGEX
            
      (?=.*[0-9]) This looks ahead to ensure a number is inside the input
      (?=.*[a-z]).{1,3} This looks ahead to ensure that a lower case letter is inside the input, and that there are not 3 or more consecutive lower case letters
      (?=.*[A-Z]) This looks ahead to ensure a capital letter is in the input
      (?=.*[,._!@#$%^&*()=+-]) This looks ahead to ensure that a punctuation character is in the input
      (?=\\S+$).{10,} This looks ahead and ensures that the password is at least 10 characters long
      Valid input;
      Bob#4IsCooL
      AliCe#2IsAweSomE
      Invalid input;
      JamesonIsCool!
      jamesonhp95
      JamEsoNhP95
   */
   public static void passwordRegex(String input)//complete
   {
      boolean match = Pattern.compile("^(?=.*[0-9])(?=.*[a-z]).{1,3}(?=.*[A-Z])(?=.*[,._!@#$%^&*()=+-])(?=\\S+$).{10,}$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
   /*
            ION REGEX
            
      (([a-z][a-z]|[A-Z][A-Z]|[a-z][A-Z]|[A-Z][a-z])+)? This allows for an optional amount of characters in sets of two to be in front of ion.
      ([i|I][o|O][n|N]) This enforces that the ending is ion, case insensitive
      Valid input;
      Exception
      CoNtRaPtIoN
      stipulation
      Invalid input;
      lion
      z i o n
      popcorn
   */
   public static void oddIonWordsRegex(String input)//complete
   {
      boolean match = Pattern.compile("^(([a-z][a-z]|[A-Z][A-Z]|[a-z][A-Z]|[A-Z][a-z])+)?([i|I][o|O][n|N])$").matcher(input).matches();
      if(match)
         System.out.println("Matches!\n");
      else
         System.out.println("No Match.\n");
   }
   
}