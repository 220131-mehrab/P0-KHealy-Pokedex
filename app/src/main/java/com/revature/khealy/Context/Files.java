package com.revature.khealy.Context;

import java.io.InputStream;

public class Files {

    public InputStream file = getClass().getClassLoader().getResourceAsStream("npd.cvs");

}
