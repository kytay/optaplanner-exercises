package org.sgdevcc.optaplanner.timetable.solverconfig;

import org.optaplanner.core.config.constructionheuristic.ConstructionHeuristicPhaseConfig;
import org.optaplanner.core.config.constructionheuristic.ConstructionHeuristicType;
import org.optaplanner.core.config.phase.PhaseConfig;
import org.optaplanner.core.config.score.director.ScoreDirectorFactoryConfig;
import org.optaplanner.core.config.solver.SolverConfig;
import org.sgdevcc.optaplanner.timetable.domain.Lesson;
import org.sgdevcc.optaplanner.timetable.domain.TimeTable;

public class DefaultSolverConfiguration extends SolverConfig {

    public DefaultSolverConfiguration() {
        super();

        ScoreDirectorFactoryConfig scoreConfig = new ScoreDirectorFactoryConfig()
                .withScoreDrls("org/sgdevcc/optaplanner/timetable/default.drl");

        PhaseConfig chPhase = new ConstructionHeuristicPhaseConfig()
                .withConstructionHeuristicType(ConstructionHeuristicType.FIRST_FIT);

        this.withSolutionClass(TimeTable.class)
                .withEntityClasses(Lesson.class)
                .withScoreDirectorFactory(scoreConfig)
                .withPhases(chPhase)
                .withDaemon(false);
    }
}
