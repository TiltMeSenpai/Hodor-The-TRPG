package org.Hodor.Hodor_the_TRPG.Model.Commands;

import java.io.Serializable;

/**
 * Abstract base class for all Command objects.
 * @author Jason, Trevor
 */

public abstract class Command<T> implements Serializable {
    private static final long serialVersionUID = -4838155228547508978L;

    /**
     * Abstract base method for all subclasses to implement.
     * @param executeOn - the object to be executed on
     */
    public abstract void execute(T executeOn);
}
