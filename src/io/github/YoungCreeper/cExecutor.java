package io.github.YoungCreeper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class cExecutor implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("research")) {		//判断命令
    		if (args.length==0) {
				sender.sendMessage("§a---------------[ResearchItem] 帮助---------------");
				sender.sendMessage("§a/research id 物品ID——搜索在线玩家中拥有指定物品的人");
				sender.sendMessage("§a/research lore 物品lore——搜索在线玩家中拥有指定物品lore的人");
    		}
    		else {
				if(args[0].equalsIgnoreCase("help")) {
					sender.sendMessage("§a------------[ResearchItem] 帮助------------");
					sender.sendMessage("§a/research id 物品ID——搜索在线玩家中拥有指定物品的人");
					sender.sendMessage("§a/research lore 物品lore——搜索在线玩家中拥有指定物品lore的人");
				}
				else{
		        	if(sender.hasPermission("researchitem.research")) {		//判断是否拥有权限
						if(args[0].equalsIgnoreCase("version")) {
				        	if(sender.hasPermission("researchitem.research.version")) {		//判断是否拥有权限
								sender.sendMessage("§a[ResearchItem] 当前版本v1.1.1");
				        	}
				        	else {
								sender.sendMessage("§a[ResearchItem] 你没有researchitem.research.version权限!");
				        	}
						}
						else {
							if(args[0].equalsIgnoreCase("id")) {
								if(sender.hasPermission("researchitem.research.id")) {	
									if (args.length==2) {
										Material itemmaterial=Material.getMaterial(args[1].toUpperCase());		//英文ID
		                        		if(!(itemmaterial instanceof Material)) {
		                        			try {
		                        				int id=Integer.valueOf(args[1]);
		                        				itemmaterial=Material.getMaterial(id);		//数字ID
		                        				} 
		                        			catch (NumberFormatException e) {
		                            			sender.sendMessage("§a[ResearchItem] 参数错误!输入/research help查看帮助");
		                        				}
		                        		}
		                        		if(itemmaterial instanceof Material) {		//确保成功获取材质
		                        			int n=0;
		                        			sender.sendMessage("§a[ResearchItem] 拥有"+itemmaterial.name()+"的玩家：");
		                        			for (Player player : Bukkit.getServer().getOnlinePlayers()) {		//便历在线玩家判断背包是否有指定物品
		                                		if (player.getInventory().contains(itemmaterial)){
		                                			sender.sendMessage(player.getName());
		                                			n=n+1;		//计数
		                                		}
		                        			}
		                        			if(n==0) {
		                        				sender.sendMessage("无");
		                        			}
		                        			sender.sendMessage("§a共"+n+"名");
		                            		
		                        		}
		                        		else {
		                        			sender.sendMessage("§a[ResearchItem] 参数错误!输入/research help查看帮助");
		                        		}
									}
									else {
			                			sender.sendMessage("§a[ResearchItem] 参数数量错误!输入/research help查看帮助");
									}
								}
								else {
									sender.sendMessage("§a[ResearchItem] 你没有researchitem.research.id权限!");
								}
							}
							else {
								if(args[0].equalsIgnoreCase("lore")) {
									if(sender.hasPermission("researchitem.research.lore")) {	
										if (args.length==2) {
											String lore=args[1];
											int n=0;
		                        			sender.sendMessage("§a[ResearchItem] 拥有物品lore包含"+lore+"的物品的玩家：");
		                        			for (Player player : Bukkit.getServer().getOnlinePlayers()) {		//遍历在线玩家获取背包
		                                		is:for (ItemStack itemstack:player.getInventory().getContents()){//遍历背包获取物品堆
		                                			try {
		                                    			if(itemstack.getItemMeta().hasLore()) {
		                                        			lo:for(String l:itemstack.getItemMeta().getLore())		//获取单个lore
		                                        				if(!(l.indexOf(lore)==-1)) {		//判断目标lore中是否含有指定lore
		                                                			sender.sendMessage(player.getName());
		                                        					n=n+1;		//计数
		                                        					break is;
		                                        				}
		                                    			} 
		                                				} 
		                                			catch (NullPointerException e) {
		                                				}
		                                		}
		                        			}
		                        			if(n==0) {
		                        				sender.sendMessage("无");
		                        			}
		                        			sender.sendMessage("§a共"+n+"名");
										}
										else {
		    	                			sender.sendMessage("§a[ResearchItem] 参数数量错误!输入/research help查看帮助");
										}
									}
									else {
										sender.sendMessage("§a[ResearchItem] 你没有researchitem.research.lore权限!");
									}
									
								}
								else {
									if(args[0].equalsIgnoreCase("name")){
										if(sender.hasPermission("researchitem.research.name")) {	
											if (args.length==2) {
												String name=args[1];
												int n=0;
			                        			sender.sendMessage("§a[ResearchItem] 拥有自定义物品名称包含"+name+"的物品的玩家：");
			                        			for (Player player : Bukkit.getServer().getOnlinePlayers()) {		//遍历在线玩家获取背包
			                                		for (ItemStack itemstack:player.getInventory().getContents()){//遍历背包获取物品堆
			                                			try {
			                                    			if(itemstack.getItemMeta().hasDisplayName()) {
			                                    				if(!(itemstack.getItemMeta().getDisplayName().indexOf(name)==-1)) {
		                                                			sender.sendMessage(player.getName());
		                                        					n=n+1;		//计数
		                                        					break;
		                                        				}
			                                    			} 
			                                			} 
			                                			catch (NullPointerException e) {
			                                			}
			                                		}
			                        			}
			                        			if(n==0) {
			                        				sender.sendMessage("无");
			                        			}
			                        			sender.sendMessage("§a共"+n+"名");
											}
											else {
												sender.sendMessage("§a[ResearchItem] 参数数量错误!输入/research help查看帮助");
											}
										}
										else {
											sender.sendMessage("§a[ResearchItem] 你没有researchitem.research.name权限!");
										}
									}
									else {
										sender.sendMessage("§a[ResearchItem] 指令不存在!输入/research help查看帮助");
									}
									
								}
							}
						}
		        	}
		        	else {
		        		sender.sendMessage("§a[ResearchItem] 你没有researchitem.research权限!");
		        	}
        		}
    		}
        }
    	return true;
    }
}
