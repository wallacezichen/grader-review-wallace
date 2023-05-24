CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

#!/bin/bash

# Specify the expected file name
expected_file="ListExamples.java"

#Check if the file exist
if [ ! -f "student-submission/$expected_file" ]; then
    echo "The submitted file does not exist in the repository."
    exit 1
fi

# If all checks pass, the submitted file is correct
echo "Submitted file is correct."

#Third Step
grading_area="grading-area"

#copy file to folder
cp -r "student-submission"/$expected_file "$grading_area"
cp -r TestListExamples.java "$grading_area"

if [ ! -f "grading-area/$expected_file" ]; then
    echo "Grading area can not find student's submission."
    exit 1
fi
echo "Student file in grading area!"

if [ ! -f "grading-area"/TestListExamples.java ]; then
    echo "Grading area can not find JUnit."
    exit 1
fi
echo "JUnit file in grading area!"

cp -r lib grading-area
echo "lib moved to grading-area"

#locate to grading folder
cd "$grading_area"

#compile
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java > compile_output.txt 2>&1
# Check if compilation was successful
if [ $? -ne 0 ]; then
    echo "Compilation failed. Please check your code and try again."
    cat compile_output.txt
    exit 1
fi
echo "Successfully compiled"

java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > junit_output.txt
echo "Successfully ran JUnit Test"

# Extract the test results
score=$(tail -n 2 junit_output.txt | head -n 1)



# Display the grade
echo "The is the result of this student's implementation score:"
echo "$score"

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

exit 0
