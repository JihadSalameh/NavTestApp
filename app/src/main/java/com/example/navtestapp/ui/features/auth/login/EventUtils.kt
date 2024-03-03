package com.example.navtestapp.ui.features.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope

/**
 * A wrapper for an event value of type [T].
 *
 * @property value The value of the event.
 */
@Stable
internal class Event<T>(val value: T)

/**
 * A mutable queue for managing events of type [T].
 */
class MutableEventQueue<T> internal constructor() : EventQueue<T>() {

    // A list to hold the events.
    private val events = mutableListOf<Event<T>>()

    // A state representing the next event to be handled.
    private val nextEventAsState = mutableStateOf<Event<T>?>(null)

    /**
     * Adds a new event to the queue.
     *
     * @param e The value of the event to be added.
     */
    fun push(e: T) {
        events.clear()
        events.add(Event(e))
        onEventsChanged()
    }

    /**
     * @return The next event to be handled as a [State].
     */
    override fun next(): State<Event<T>?> {
        return nextEventAsState
    }

    /**
     * Removes the handled event from the queue.
     *
     * @param event The event that has been handled.
     */
    override fun onHandled(event: Event<T>) {
        events.remove(event)
        onEventsChanged()
    }

    // Updates the state representing the next event to be handled.
    private fun onEventsChanged() {
        nextEventAsState.value = events.firstOrNull()
    }
}

/**
 * Factory function to create a new [MutableEventQueue] instance.
 */
fun <T> mutableEventQueue() = MutableEventQueue<T>()

/**
 * An abstract class representing a queue of events of type [T].
 */
abstract class EventQueue<T> {
    /**
     * @return The next event to be handled as a [State].
     */
    internal abstract fun next(): State<Event<T>?>

    /**
     * Indicates that the given event has been handled.
     *
     * @param event The event that has been handled.
     */
    internal abstract fun onHandled(event: Event<T>)
}

/**
 * A composable function to handle events from a given [EventQueue].
 *
 * @param eventQueue The [EventQueue] from which to handle events.
 * @param handler The function to call to handle each event. This function is a suspending function,
 * and is called within a [CoroutineScope].
 */
@Composable
fun <T> EventHandler(
    eventQueue: EventQueue<T>,
    shouldHandle: (T) -> Boolean = { true },
    handler: suspend CoroutineScope.(T) -> Unit,
) {
    val e = eventQueue.next().value
    LaunchedEffect(e) {
        if (e != null && shouldHandle(e.value)) {
            handler(e.value)
            eventQueue.onHandled(e)
        }
    }
}