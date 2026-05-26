class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> setA=new HashSet<>();
        HashSet<Character> setB=new HashSet<>();

        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch)) setA.add(ch);
            else setB.add(Character.toLowerCase(ch));
        }
        int count=0;
        for(char ch:setA){
            if(setB.contains(ch)){
                count++;
            }
        }
    return count;
    }
}