using Xunit;
using System;
using System.Collections.Generic;

/*
 * $ dotnet test --filter "FullyQualifiedName~condition_coverage_only" --collect:"XPlat Code Coverage"
 * $ reportgenerator "-reports:test-u02-unit-testing/TestResults/4b033c20-7fd9-42c3-b77a-6822073720f0/coverage.cobertura.xml" "-targetdir:covreport" -reporttpes:Html
 */
namespace it.unibo.testlecture.u03_coverage
{
    public class CoverageExample
    {
        [Fact]
        public void condition_coverage_only(){
            // To cover all the conditions, just ensure that each one takes a different value
            ProgramToCover.methodToCover(false, true, false, true, true, 3);
            ProgramToCover.methodToCover(true, false, true, false, false, 3);
        }

        [Fact]
        public void decision_coverage(){
            // To cover all the decisions, just ensure that each one takes a different value
            ProgramToCover.methodToCover(true, true, false, false, true, 3);
            ProgramToCover.methodToCover(false, false, true, false, false, 3);
        }

        [Fact]
        public void decision_condition_coverage(){
            ProgramToCover.methodToCover(true, true, false, false, true, 3);
            ProgramToCover.methodToCover(false, false, true, true, false, 3);
        }
    }
}
