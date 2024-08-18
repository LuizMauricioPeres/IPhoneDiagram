package project_iphone;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import exceptions.PowerExcption;

public class Start {
    public static void main(String[] args)
    {

        IPhone iPhone = new IPhone();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String charOption;

        System.out.println("\nChoose an option: ");
        System.out.println("P. Power");
        do {

            try{
                charOption=br.readLine();
            }catch (Exception e){
                charOption="";
            }
            switch ((charOption).toLowerCase()) {
                case "1":
                    try{
                        iPhone.call(utilsTest.generateRandomNumberPhone());;
                    } catch (PowerExcption e) {
                        continue;
                    }
                    break;
                case "2":
                    try{
                        iPhone.selectMusic();
                    } catch (PowerExcption e) {
                        continue;
                    }
                    break;
                case "3":
                    try{
                        iPhone.browse();
                    } catch (PowerExcption e) {
                        continue;
                    }

                    break;
                case "p":
                    iPhone.power();
                    break;
                case "q":
                    break;
                default:
                    continue;
            }
            System.out.println("\nChoose an option: ");
            System.out.println("1. Call");
            System.out.println("2. Select Music");
            System.out.println("3. Browse");
            System.out.println("P. Power");

        } while (!(charOption).toLowerCase().equals("q"));
    }
}
