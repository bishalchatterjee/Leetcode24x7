class Solution {
    public boolean checkValidString(String s) {
          if(s=="") return false;
      int openFirst=0;
      int openSecond=0;
      int openThird=0;
     
      for(int i=0; i<s.length(); i++){
        char c=s.charAt(i);
        if(c=='(' || c=='{' || c=='['){
          if(c=='(') openFirst++;
          else if(c=='{') openSecond++;
          else{
            openThird++;
          }
        }else{
          if(c==')' && openFirst>0){
            openFirst--;
          }else if(c=='}' && openSecond>0){
            openSecond--;
          }else if(c==']' && openThird>0){
            openThird--;
          }
        }
      }
      return openFirst==0 && openSecond==0 && openThird==0;
    }
}
