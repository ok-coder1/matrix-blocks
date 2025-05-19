package com.okcoder1.matrixblocks;

import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatrixBlocksClient implements ClientModInitializer {
	public static final String MOD_ID = "matrix-blocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		LOGGER.info("Matrix Blocks has started on the client!");
	}
}