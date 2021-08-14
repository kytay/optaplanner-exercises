package org.sgdevcc.optaplanner.timetable.config;

import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.config.solver.SolverConfig;
import org.optaplanner.core.config.solver.SolverManagerConfig;
import org.sgdevcc.optaplanner.timetable.solverconfig.DefaultSolverConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SolverConfig solverConfig() {
        return new DefaultSolverConfiguration();
    }

    @Bean
    public SolverManager solverManager() {
        return SolverManager.create(new DefaultSolverConfiguration(), new SolverManagerConfig());
    }
}
