package com.cpass.cpass.services;

import com.cpass.cpass.requests.MakeCallRequestBody;
import com.cpass.cpass.responses.MakeCallResponseBody;

/**
 *
 * @author Laughmare
 */
public interface CpassService {

    MakeCallResponseBody makeCall(MakeCallRequestBody body);
}
