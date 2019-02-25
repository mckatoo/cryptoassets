/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-02-01 15:28:55
 * @modify date 2019-02-01 15:28:55
 * @desc [description]
 */

package io.ikatoo.cryptoassets.interfaces.error;

/**
 * CustomErrorType
 */
public class CustomErrorType {
    private String _errorMessage;

    public CustomErrorType(String errorMessage) {
        _errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return _errorMessage;
    }
}
