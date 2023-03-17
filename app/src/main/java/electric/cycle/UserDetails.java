package electric.cycle;

public class UserDetails {

    private String userName,userMobile,userCity,userEmail,userPassword;

    public UserDetails() {

    }
    public UserDetails(String userName, String userCity, String userEmail, String userMobile, String userPassword) {
        this.userName = userName;
        this.userCity = userCity;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userPassword=userPassword;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userAddress) {
        this.userCity = userAddress;
    }


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }



}
