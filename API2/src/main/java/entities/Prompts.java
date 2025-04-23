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
                .addLine("Your task is to improve a Python unit test script for a specific function.")
                .addLine("Analyze the code and find ways to improve its quality, correctness, and readability.")
                .addLine("You may find bugs, redundant code, or opportunities to make the script more concise.")
                .addLine("As your task is to improve a complete Python unit test script for a given function, you need to find ways to make the code better, finding errors or giving suggestions to make the code shorter, but remaining functional.")
                .addLine("The function will be provided below, and you must analyze its parameters and return type.")
                .addLine("Ensure that the generated code does not change the original code objective.")
                .addLine("Your response must be a valid Python script using the 'unittest' module.")
                .addLine("You can include any comments in the generated code explaining the changes that you made.")
                .addLine("Strictly follow these guidelines:")
                .addLine("- DO NOT exclude or change any previous comments in the code.")
                .addLine("- Use 'unittest.TestCase' to structure the test class.")
                .addLine("- Define multiple test methods to verify different valid inputs.")
                .addLine("- If the function expects integers, use only valid integers (no floats, strings, or special characters).")
                .addLine("- If the function expects positive numbers, do not include negative values.")
                .addLine("- If the function expects a list, ensure the test values are properly formatted as a list.")
                .addLine("- Ensure that the generated test cases do not cause the function to fail.")
                .addLine("- The function should be imported in the test script to allow execution.")
                .addLine("- Include a 'if __name__ == \"__main__\"' block to allow running the tests.")
                .addSeparator()
                .addLine("Before improving the test script, here are some examples of Python code improvement.")
                .addLine("These examples show how a code can be written in a shorter and more concise way, while keeping the same functionality.")
                .addSeparator()
                .addLine("Example 1. - Reference version:")
                .addLine("squares = []")
                .addLine("for i in range(10):")
                .addLine("    squares.append(i * i)")
                .addLine("")
                .addLine("Example 1. - Improved version:")
                .addLine("squares = [i * i for i in range(10)]")
                .addSeparator()
                .addLine("Example 2. - Reference version:")
                .addLine("def is_even(n):")
                .addLine("    if n % 2 == 0:")
                .addLine("        return True")
                .addLine("    else:")
                .addLine("        return False")
                .addLine("")
                .addLine("Example 2. - Improved version:")
                .addLine("def is_even(n):")
                .addLine("    return n % 2 == 0")
                .addSeparator()
                .addLine("Example 3. - Reference version:")
                .addLine("numbers = [1, 2, 3, 4, 5, 6]")
                .addLine("even_sum = 0")
                .addLine("for number in numbers:")
                .addLine("  if number % 2 == 0:")
                .addLine("      even_sum += number")
                .addLine("print(even_sum)")
                .addLine("")
                .addLine("Example 3. - Improved version:")
                .addLine("numbers = [1, 2, 3, 4, 5, 6]")
                .addLine("print(sum(n for n in numbers if n % 2 == 0))")
                .addSeparator()
                .addLine("Use these improvement principles when reviewing the test script.")
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
