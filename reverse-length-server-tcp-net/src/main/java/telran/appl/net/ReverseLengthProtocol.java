package telran.appl.net;

import telran.net.*;

public class ReverseLengthProtocol implements Protocol {
    @Override
    public Response getResponse(Request request) {
        String type = request.requestType();
        String data = request.requestData();
        switch (type) {
            case "reverse":
                return new Response(ResponseCode.OK, new StringBuilder(data).reverse().toString());
            case "length":
                return new Response(ResponseCode.OK, String.valueOf(data.length()));
            default:
                return new Response(ResponseCode.WRONG_TYPE, "Unknown request type: " + type);
        }
    }
}
