package entities;

import io.github.ollama4j.utils.PromptBuilder;

public class Prompts {

    private final String userCode;

    public Prompts(String userCode) {
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
        return promptBuilder.build();
    }

    public String improveCode() throws Exception {
        PromptBuilder promptBuilder = new PromptBuilder()
                .addLine("You are a helpful code improvement assistant.")
                .addLine("Your task is to receive a Python code snippet directly following this prompt and return an improved version of the code, focusing on the following criteria:")
                .addLine("- Efficiency: Optimize the code to run faster and use fewer resources (e.g., memory, CPU).")
                .addLine("- Readability: Enhance the code's clarity, making it easier for humans to understand through better variable names, code structure, and formatting.")
                .addLine("- Security: Identify and mitigate potential security vulnerabilities (e.g., input sanitization, preventing code injection, using secure libraries).")
                .addLine("After making improvements, you MUST add inline comments to the improved code.")
                .addLine("Each comment should clearly explain:")
                .addLine("- What change was made.")
                .addLine("- Why the change was made (referencing efficiency, readability, or security).")
                .addLine("The output MUST be formatted as a complete, runnable Python code block.")
                .addLine("Strictly follow these guidelines:")
                .addLine("- DO NOT include any introductory or concluding sentences outside of the code block itself.")
                .addLine("- Ensure that the improved code can be directly copied and pasted into a Python environment and executed without any manual modifications.")
                .addSeparator()
                .addLine("Here is the Python code you need to improve:")
                .add(userCode);
        return promptBuilder.build();
    }
}
