/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.geostax.etl.node;

import java.util.HashMap;
import java.util.Map;

import com.geostax.etl.Channel;
import com.geostax.etl.SinkRunner;
import com.geostax.etl.SourceRunner;
import com.google.common.collect.ImmutableMap;

public class SimpleMaterializedConfiguration implements MaterializedConfiguration {

	private final Map<String, Channel> channels;
	private final Map<String, SourceRunner> sourceRunners;
	private final Map<String, SinkRunner> sinkRunners;

	public SimpleMaterializedConfiguration() {
		channels = new HashMap<String, Channel>();
		sourceRunners = new HashMap<String, SourceRunner>();
		sinkRunners = new HashMap<String, SinkRunner>();
	}

	@Override
	public String toString() {
		return "{ sourceRunners:" + sourceRunners + " sinkRunners:" + sinkRunners + " channels:" + channels + " }";
	}

	@Override
	public void addSourceRunner(String name, SourceRunner sourceRunner) {
		sourceRunners.put(name, sourceRunner);
	}

	@Override
	public void addSinkRunner(String name, SinkRunner sinkRunner) {
		sinkRunners.put(name, sinkRunner);
	}

	@Override
	public void addChannel(String name, Channel channel) {
		channels.put(name, channel);
	}

	@Override
	public ImmutableMap<String, Channel> getChannels() {
		return ImmutableMap.copyOf(channels);
	}

	@Override
	public ImmutableMap<String, SourceRunner> getSourceRunners() {
		return ImmutableMap.copyOf(sourceRunners);
	}

	@Override
	public ImmutableMap<String, SinkRunner> getSinkRunners() {
		return ImmutableMap.copyOf(sinkRunners);
	}

}
