package com.catp.cgc.constants;
/**
 * 
 *
 *
 */

public class QueryConstants {

	public static final String SELECT_PLAYER="select playerid,playerpassword,playeragegroup,playerduration from player_id_generation where playerid=? and playerpassword=?";
	public static final String SELECT_GAME="select game_title,game_type,base_price,game_rating from game_registration ";
	public static final String SELECT_DISCOUNT="select discount from discount where playerageGroup=?  and Duration=?  ";
}
