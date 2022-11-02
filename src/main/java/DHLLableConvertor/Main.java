package DHLLableConvertor;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class Main {
    public static void main(String[] args) throws IOException {
// TODO add user prompt

        //String filePath = userInput.nextLine();
        ArgumentParser parser = ArgumentParsers
                .newFor("argparseTest")
                .build().description("Returns a String");
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
            System.out.println("file path: " +(String) res.get("path"));
            File file = new File((String) res.get("path"));
            System.out.println("Type: " +(String) res.get("type"));
            PDDocument pd = PDDocument.load(file);
            Label.createLabel(pd, (String) res.get("type"));
        } catch (ArgumentParserException e) {
            parser.handleError(e);
        }


    }

}