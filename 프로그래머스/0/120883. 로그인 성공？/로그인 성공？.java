class Solution {
    public String solution(String[] id_pw, String[][] db) {
        
        for (String[] check : db) {
            if (check[0].equals(id_pw[0]) && check[1].equals(id_pw[1])) {
                return "login";
            }
            else if (check[0].equals(id_pw[0]) && !check[1].equals(id_pw[1])) {
                return "wrong pw";
            }
        }
        
        return "fail";
    }
}