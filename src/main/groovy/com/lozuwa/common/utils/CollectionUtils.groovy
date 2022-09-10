package com.lozuwa.common.utils

public class CollectionUtils {

    public CollectionUtils() {
    }

    public LinkedList<Object> filterCollection(LinkedList<Object> collection, String property) {
        LinkedList<Object> filteredCollection = new LinkedList<>()
        for (Object element: collection) {
            filteredCollection.add(element.getOrDefault(property, null))
        }
        return filteredCollection
    }

    public LinkedHashSet<Object> filterCollection(LinkedHashSet<Object> collection, String property) {
        LinkedList<Object> filteredCollection = new LinkedList<>()
        for (Object element: collection) {
            filteredCollection.add(element.getOrDefault(property, null))
        }
        return filteredCollection
    }
}
