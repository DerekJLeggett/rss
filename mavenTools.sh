mvn versions:use-latest-versions
mvn versions:update-parent
mvn versions:display-plugin-updates
mvn dependency:analyze
mvn spotless:check
mvn spotless:apply
mvn -U clean install