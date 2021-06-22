package com.puppycrawl.tools.checkstyle.checks.imports.importorder;

import org.antlr.v4.runtime.*; // ok

import java.util.Set; // violation

import static java.lang.Math.PI; // violation
import static org.antlr.v4.runtime.Recognizer.EOF; // ok

/*
 * Config:
 * option = bottom
 * groups = {org, java}
 * ordered = true
 * separated = false
 * separatedStaticGroups = false
 * caseSensitive = true
 * staticGroups = {}
 * sortStaticImportsAlphabetically = false
 * useContainerOrderingForStatic = false
 */
public class InputImportOrderStaticGroupOrderBottom2
{

}
