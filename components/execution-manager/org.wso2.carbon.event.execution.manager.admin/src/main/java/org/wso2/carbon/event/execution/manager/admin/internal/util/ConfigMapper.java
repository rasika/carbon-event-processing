/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.wso2.carbon.event.execution.manager.admin.internal.util;

import org.wso2.carbon.event.execution.manager.admin.dto.config.ParameterDTO;
import org.wso2.carbon.event.execution.manager.admin.dto.config.TemplateConfigDTO;
import org.wso2.carbon.event.execution.manager.core.structure.config.Parameter;
import org.wso2.carbon.event.execution.manager.core.structure.config.TemplateConfig;

import java.util.List;

public class ConfigMapper {

    public static TemplateConfigDTO[] mapConfigurations(List<TemplateConfig> templateConfigs) {
        TemplateConfigDTO[] templateConfigDTOs = new TemplateConfigDTO[templateConfigs.size()];

        for (int i = 0; i < templateConfigDTOs.length; i++) {
            templateConfigDTOs[i] = mapConfiguration(templateConfigs.get(i));
        }
        return templateConfigDTOs;
    }

    public static TemplateConfigDTO mapConfiguration(TemplateConfig templateConfig) {
        TemplateConfigDTO templateConfigDTO = new TemplateConfigDTO();
        templateConfigDTO.setName(templateConfig.getName());
        templateConfigDTO.setDescription(templateConfig.getDescription());
        templateConfigDTO.setFrom(templateConfig.getFrom());
        templateConfigDTO.setParameterDTOs(mapParameters(templateConfig.getParameters()));
        return templateConfigDTO;
    }

    public static TemplateConfig mapConfiguration(TemplateConfigDTO configDTO) {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setName(configDTO.getName());
        templateConfig.setDescription(configDTO.getDescription());
        templateConfig.setFrom(configDTO.getFrom());
        templateConfig.setParameters(mapParameters(configDTO.getParameterDTOs()));
        return templateConfig;
    }

    public static Parameter[] mapParameters(ParameterDTO[] parameterDTO) {
        Parameter[] parameters = new Parameter[parameterDTO.length];

        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = mapParameter(parameterDTO[i]);
        }

        return parameters;
    }

    public static ParameterDTO[] mapParameters(Parameter[] parameters) {
        ParameterDTO[] parameterDTOs = new ParameterDTO[parameters.length];

        for (int i = 0; i < parameterDTOs.length; i++) {
            parameterDTOs[i] = mapParameter(parameters[i]);
        }

        return parameterDTOs;
    }

    public static Parameter mapParameter(ParameterDTO parameterDTO) {
        Parameter parameter = new Parameter();
        parameter.setValue(parameterDTO.getValue());
        return parameter;
    }

    public static ParameterDTO mapParameter(Parameter parameter) {
        ParameterDTO parameterDTO = new ParameterDTO();
        parameterDTO.setValue(parameter.getValue());
        return parameterDTO;
    }


}
