package io.github.YoungCreeper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class cExecutor implements CommandExecutor {
	private final ResearchItem plugin;
	
    public cExecutor(ResearchItem plugin) {
        this.plugin = plugin;
    }

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("research")) {		//�ж�����
        	if(sender.hasPermission("researchitem.research")) {		//�ж��Ƿ�ӵ��Ȩ��
        		if (args.length==0) {
					sender.sendMessage("��a-------------[ResearchItem] ����-------------");
					sender.sendMessage("��a/research id ��ƷID�����������������ӵ��ָ����Ʒ����");
					sender.sendMessage("��a/research lore ��Ʒlore�����������������ӵ��ָ����Ʒlore����");
        		}
        		else {
    				if(args[0].equalsIgnoreCase("help")) {
    					sender.sendMessage("��a----------[ResearchItem] ����----------");
    					sender.sendMessage("��a/research id ��ƷID�����������������ӵ��ָ����Ʒ����");
    					sender.sendMessage("��a/research lore ��Ʒlore�����������������ӵ��ָ����Ʒlore����");
    				}
    				else{
    					if(args[0].equalsIgnoreCase("version")) {
    						sender.sendMessage("��a[ResearchItem] ��ǰ�汾v1.0.0");
    					}
    					else {
    						if(args[0].equalsIgnoreCase("id")) {
    							if (args.length==2) {
    								Material itemmaterial=Material.getMaterial(args[1].toUpperCase());		//Ӣ��ID
                            		if(!(itemmaterial instanceof Material)) {
                            			try {
                            				int id=Integer.valueOf(args[1]);
                            				itemmaterial=Material.getMaterial(id);		//����ID
                            				} 
                            			catch (NumberFormatException e) {
                                			sender.sendMessage("��a[ResearchItem] ��������!����/research help�鿴����");
                            				}
                            		}
                            		if(itemmaterial instanceof Material) {		//ȷ���ɹ���ȡ����
                            			int n=0;
                            			sender.sendMessage("��a[ResearchItem] ӵ��"+itemmaterial.name()+"����ң�");
                            			for (Player player : Bukkit.getServer().getOnlinePlayers()) {		//������������жϱ����Ƿ���ָ����Ʒ
                                    		if (player.getInventory().contains(itemmaterial)){
                                    			sender.sendMessage(player.getName());
                                    			n=n+1;		//����
                                    		}
                            			}
                            			if(n==0) {
                            				sender.sendMessage("��");
                            			}
                            			sender.sendMessage("��a��"+n+"��");
                                		
                            		}
                            		else {
                            			sender.sendMessage("��a[ResearchItem] ��������!����/research help�鿴����");
                            		}
    							}
    							else {
    	                			sender.sendMessage("��a[ResearchItem] ������������!����/research help�鿴����");
    							}
    							
    						}
    						else {
    							if(args[0].equalsIgnoreCase("lore")) {
    								if (args.length==2) {
    									String lore=args[1];
    									int n=0;
                            			sender.sendMessage("��a[ResearchItem] ӵ����Ʒlore����"+lore+"����Ʒ����ң�");
                            			for (Player player : Bukkit.getServer().getOnlinePlayers()) {		//����������һ�ȡ����
                                    		is:for (ItemStack itemstack:player.getInventory().getContents()){//����������ȡ��Ʒ��
                                    			try {
                                        			if(itemstack.getItemMeta().hasLore()) {
                                            			lo:for(String l:itemstack.getItemMeta().getLore())		//��ȡ����lore
                                            				if(!(l.indexOf(lore)==-1)) {		//�ж�Ŀ��lore���Ƿ���ָ��lore
                                                    			sender.sendMessage(player.getName());
                                            					n=n+1;		//����
                                            					break is;
                                            				}
                                        			} 
                                    				} 
                                    			catch (NullPointerException e) {
                                    				}
                                    		}
                            			}
                            			if(n==0) {
                            				sender.sendMessage("��");
                            			}
                            			sender.sendMessage("��a��"+n+"��");
    								}
    								else {
        	                			sender.sendMessage("��a[ResearchItem] ������������!����/research help�鿴����");
    								}
    							}
    							else {
    								sender.sendMessage("��a[ResearchItem] ָ�����!����/research help�鿴����");
    							}
    						}
    					}
            		}
        		}
        	}
        	else {
        		sender.sendMessage("��a[ResearchItem] ��û��Ȩ����ô��!");
        	}
        }
    	return true;
    }
}
