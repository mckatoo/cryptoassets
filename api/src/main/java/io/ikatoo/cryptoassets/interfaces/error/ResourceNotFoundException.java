/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-02-07 22:30:08
 * @modify date 2019-02-07 22:30:08
 * @desc [description]
 */

package io.ikatoo.cryptoassets.interfaces.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceNotFoundException
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 238877096871057753L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}