public class wrapper {

   public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String loc, String phrase){
        ArrayList<QuakeEntry> ans = new ArrayList<QuakeEntry>();
        Pattern pattern;
        
        switch  (loc){
            //HOW TO ACCESS VAR IN REG EX
                case "start" :
                    pattern = Pattern.compile("^("+ phrase+")(.*)?");
// also tried this:      pattern = Pattern.compile("^\\s*"+ phrase +"\\s*(.*)");
                    break;
                //can use $ to check end of line -- 
                case "end" : 
                    pattern = Pattern.compile("(.+)?("+ phrase +")\\z"); 
                    break;
                case "any" :
                    pattern = Pattern.compile("(.*)(" +phrase+ ")(.*)");
                    break;
                default :
                    System.out.println("must be a problem with your params");
                    throw new IllegalArgumentException();
        }
               
        for (QuakeEntry qe: quakeData){
            String desc = qe.getInfo();
            Matcher m = pattern.matcher(desc);
            if (m.matches()){
                ans.add(qe);
            
            }
        }
        return ans;
    }

}
