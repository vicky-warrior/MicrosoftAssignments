class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        int[] map = new int[26];
        // map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        
        int v = 0;
        
        for(int i = 0; i < s.length(); i++){
            v <<= 2;
            v |= map[s.charAt(i) - 'A'];
            
            if(i < 9) continue;
            
            v &= 0xfffff;
            if(!seen.add(v)) repeated.add(s.substring(i - 9, i+1));
            
        }
        
        return new ArrayList(repeated);
        
    }
}