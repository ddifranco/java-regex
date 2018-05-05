public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source =  "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        
        System.out.println("read data for " + list.size() + " quakes");
        
        //        String  testPhrase = "California";
        //        String loc = "end";
        //        String  testPhrase = "Can";
        //        String loc = "any";
        //String  testPhrase = "Explosion";
        //String loc = "any";
        
        String  testPhrase = "\\(49.39, -120.44\\)";
        String loc = "start";
        ArrayList<QuakeEntry> ans = filterByPhrase(list, loc, testPhrase);
        
        for(QuakeEntry qe: ans){
            System.out.println(qe.toString() + "\n");
        }
        System.out.println("found " + ans.size() + " quakes matching that search");
    }

