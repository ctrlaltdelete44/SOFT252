/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import requests.AppointmentRequest;
import requests.PrescriptionRequest;
import requests.Request;
import utilities.serialised.RequestSingleton;

/**
 * request adapter to retrieve a reference to a request given it's information
 * as defined by it's "PrintRequest" template
 *
 * @author davie
 */
public class RequestAdapter implements IConvert {

    private final String strRequest;

    /**
     *
     * @param strRequest - the request information to search for
     */
    public RequestAdapter(String strRequest) {
        this.strRequest = strRequest;
    }

    /**
     * loops through a list of all requests and compares their information to
     * that contained in the request information summary
     *
     * @return - returns a reference to the request if found, else null
     */
    @Override
    public Request convert() {
        //loops through all requests
        for (Request r : (ArrayList<Request>)RequestSingleton.getOrCreate().getData()) {
            if (strRequest.contains(r.getAccount().getFirstName()) && strRequest.contains(r.getAccount().getSurname()) && strRequest.contains(r.getRequestType().toString())) {
                //if the request is not completed, returns null. should never be called, but just in case
                if (null == r.getRequestType()) {
                    return null;
                } else {
                    switch (r.getRequestType()) {
                        //certain request types require more validation to ensure that the request retrieved is the correct one
                        case APPOINTMENT:
                            AppointmentRequest ar = (AppointmentRequest) r;
                            if (strRequest.contains(ar.getDate().toString()) && (strRequest.contains(ar.getDoctor().getUniqueId()))) {
                                return r;
                            }
                            break;
                        case PRESCRIPTION:
                            PrescriptionRequest pr = (PrescriptionRequest) r;
                            String strQuantity = "" + pr.getPrescription().getQuantity();
                            if (strRequest.contains(pr.getPrescription().getMedicine()) && strRequest.contains(strQuantity)) {
                                return r;
                            }
                            break;
                        default:
                            return r;
                    }
                }
            }
        }
        return null;
    }
}
