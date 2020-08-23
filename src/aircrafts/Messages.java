package src.aircrafts;

public class Messages {
    public String Messages(String weather){
        switch (weather){
            case "SUN":
                return "Its Sunny outside. Take a lot of pictures";
            case "FOG":
                return "You might not see clearly outside, I hope the pilot does";
            case "SNOW":
                return "Its Snowy outside, Try to cuddle";
            case "RAIN":
                return "Its a Rainy day, but there are no holes im the aircraft";
            default: return "Something Went Wrong";
        }
    }
}
