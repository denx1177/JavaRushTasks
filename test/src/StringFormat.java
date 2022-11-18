public class StringFormat {
    public static void main(String[] args) {
        String result = "";
        String countryCode = 38 + "";
        String phoneNumber = "71112233";

        String netCode = String.format("%1$3s",phoneNumber.substring(0, phoneNumber.length()-7)).replace(' ', '0');
        phoneNumber = phoneNumber.substring(phoneNumber.length()-7);

        result = "+" + countryCode + "(" + netCode + ")" +
                String.format("%1$s-%2$s-%3$s", phoneNumber.substring(0,3),phoneNumber.substring(3,5),phoneNumber.substring(5));

        System.out.println(result);
    }
}
