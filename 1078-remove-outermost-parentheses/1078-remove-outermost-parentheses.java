class Solution {
    public String removeOuterParentheses(String s) {
      Stack<Character> st=new Stack();

      StringBuilder res=new StringBuilder();
      // 0 1 2 3 4 5 6 7 8 9
      // ( ( ) ( ) ) ( ( ) )

      // count=2

      int countOpenBrackets=0;

      for(char ch: s.toCharArray()){
          if(ch=='('){
              if(countOpenBrackets >= 1){
                  res.append("(");
              }
              countOpenBrackets++;
              st.push(ch);
          }else{
              if(st.peek()=='('){
                  if(countOpenBrackets >= 2 ){
                      res.append(")");
                  }
                  countOpenBrackets--;
                  st.pop();
              }
          }
      }
      return res.toString();
    }
}