package com.okcoder1.matrixblocks;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatrixBlocks implements ModInitializer {
	public static final String MOD_ID = "matrix-blocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		LOGGER.info("Matrix Blocks has initialized.");
	}
}