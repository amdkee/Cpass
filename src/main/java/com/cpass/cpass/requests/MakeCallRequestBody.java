package com.cpass.cpass.requests;

import lombok.Value;

/**
 *
 * @author Laughmare
 */
@Value
public class MakeCallRequestBody {

    String caller;
    String cally;
    String callType;
}
