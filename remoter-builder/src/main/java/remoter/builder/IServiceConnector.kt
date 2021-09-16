package remoter.builder

import android.os.Binder
import android.os.IBinder

/**
 * Connects with a service and returns a [Binder] through the suspendable [getService] function
 *
 * @see ServiceConnector for an implementation of this.
 */
interface IServiceConnector {

    /**
     * Returns the [IBinder] for the service, by binding to it as needed
     */
    suspend fun getService(): IBinder

    /**
     * Disconnect from the service
     */
    fun disconnect()

    /**
     * Set up a callback to get called when service connects
     */
    fun onServiceConnect(callback: ((IBinder) -> Unit)?) {}

    /**
     * Set up a callback to get called when service disconnects
     */
    fun onServiceDisconnect(callback: (() -> Unit)?) {}


}