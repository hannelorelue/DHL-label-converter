package org.DHLLabelConvertor;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class Main {
    public static void main(String[] args) throws IOException {

        //String filePath = userInput.nextLine();
        ArgumentParser parser = ArgumentParsers
                .newFor("argparseTest")
                .build().description("Returns a 62mm x 180mm version of a DHL PDF label.");
        parser.addArgument("-path", "-p")
                .metavar("path")
                .help("File path of pdf");
        parser.addArgument("-type", "-t")
                .metavar("labelType")
                .type(String.class)
                .choices("a", "b")
                .setDefault("a")
                .help("a is for national shipping labels (Default), b for international shipping labels");
        try {
            Namespace res = parser.parseArgs(args);
            try {
                //System.out.println("file path: " +(String) res.get("path"));
                File file = new File((String) res.get("path"));
                //System.out.println("Type: " +(String) res.get("type"));
                PDDocument pd = PDDocument.load(file);
                Label.createLabel(pd, res.get("type"), (String) res.get("path"));
            } catch (NullPointerException n) {
                System.out.println("Please enter a path to the PDF document with the option -path.");
            }

        } catch (ArgumentParserException e) {
            parser.handleError(e);
        }
    }

}