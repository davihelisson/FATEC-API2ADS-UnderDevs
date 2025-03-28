package entities;

import io.github.ollama4j.utils.PromptBuilder;

public class Prompts {
    private final String userCode;
    
    public Prompts(String userCode){
        this.userCode = userCode;
    }
    
    public String generateCode() throws Exception {
        
        PromptBuilder promptBuilder = new PromptBuilder()
            .addLine("You are an expert in unit testing and software quality assurance.")
            .addLine("Your task is to generate a complete Python unit test script for a given function.")
            .addLine("The function will be provided below, and you must analyze its parameters and return type.")
            .addLine("Ensure that the generated test cases cover multiple valid scenarios.")
            .addLine("Your response must be a valid Python script using the 'unittest' module.")
            .addLine("Strictly follow these guidelines:")
            .addLine("- DO NOT include any comments in the generated code.")
            .addLine("- Use 'unittest.TestCase' to structure the test class.")
            .addLine("- Define multiple test methods to verify different valid inputs.")
            .addLine("- If the function expects integers, use only valid integers (no floats, strings, or special characters).")
            .addLine("- If the function expects positive numbers, do not include negative values.")
            .addLine("- If the function expects a list, ensure the test values are properly formatted as a list.")
            .addLine("- Ensure that the generated test cases do not cause the function to fail.")
            .addLine("- The function should be imported in the test script to allow execution.")
            .addLine("- Include a 'if __name__ == \"__main__\"' block to allow running the tests.")
            .addSeparator()
            .addLine("import unittest")
            .addLine("from my_module import function_name")
            .addLine("")
            .addLine("class TestFunction(unittest.TestCase):")
            .addLine("")
            .addLine("    def test_case_1(self):")
            .addLine("        self.assertEqual(function_name(val1, val2), expected_output)")
            .addLine("")
            .addLine("    def test_case_2(self):")
            .addLine("        self.assertEqual(function_name(val3, val4), expected_output)")
            .addLine("")
            .addLine("    def test_case_3(self):")
            .addLine("        self.assertEqual(function_name(val5, val6), expected_output)")
            .addLine("")
            .addLine("if __name__ == \"__main__\":")
            .addLine("    unittest.main()")
            .addSeparator()
            .addLine("Python function:")
            .add(userCode);
        
        /*
        // Lista de casos de prompt antigos
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine("You are an expert code generation assistant specializing in Python programming and also understand different programming languages.")
                        .addLine("Your objective is to accurately translate natural language task descriptions into executable Python code.")
                        .addLine("Given a question, answer ONLY with code.")
                        .addLine("Produce clean, formatted and indented code in markdown format.")
                        .addLine("Carefully review the given task description and write Python code that fulfills the specified requirements.")
                        .addLine("DO NOT include ANY extra text apart from code. Follow this instruction very strictly!")
                        .addLine("Ensure that the code passes any provided test cases.")
                        .addLine("If there's any additional information you want to add, use comments within code.")
                        .addLine("Answer only in the programming language that has been asked for.")
                        .addLine("Please consider both efficiency and accuracy in your code generation process.")
                        .addLine("Additionally, provide a detailed explanation of the code's functionality and how it addresses the given task.")
                        .addSeparator()
                        .addLine("Example 1: Sum 2 numbers in Python")
                        .addLine("Answer:")
                        .addLine("def sum(num1: int, num2: int) -> int:")
                        .addLine("    return num1 + num2")
                        .addSeparator()
                        .addLine("Example 2: If you have a list containing only numbers, check whether two consecutive '2's appear in the list of integers.")
                        .addLine("Answer:")
                        .addLine("def has22(nums):")
                        .addLine("    return '2, 2' in str(nums)")
                        .addSeparator()
                        .addLine("Example 3: Make a function that calculates the n-th Fibonacci element")
                        .addLine("Answer:")
                        .addLine("def fib(n):")
                        .addLine("    if n == 1 or n == 2:")
                        .addLine("        return 1")
                        .addLine("    else:")
                        .addLine("        return fib(n-1) + fib(n-2)")
                        .addSeparator()
                        .addLine("Example 4: Write a Python program that defines a method to calculate the factorial of a number")
                        .addLine("Answer:")
                        .addLine("def fat(n):")
                        .addLine("    if n ==1 or n == 0:")
                        .addLine("        return 1")
                        .addLine("    else:")
                        .addLine("        return n * fat(n-1)")
                        .add("Generate Python code based on the text provided in the TextArea."); */
        return promptBuilder.build();
    }
}
/*
Faça a alteração do prompt para geração de testes unitários:
https://chatgpt.com/share/67e2b1cc-e250-800a-8a2e-75dee02592e3
*/
