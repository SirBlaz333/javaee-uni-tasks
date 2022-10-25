package com.arsenii.task7;

import java.util.TreeMap;

public interface DataElement {
    TreeMap<String, String> access(DataElementVisitor visitor);
}
