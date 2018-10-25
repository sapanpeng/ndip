package com.tenghong.ndip.service.sys.impl;

import com.tenghong.ndip.mapper.sys.SysResourcesMapper;
import com.tenghong.ndip.mapper.sys.SysResourcesPkgMapper;
import com.tenghong.ndip.model.sys.SysResourcesPkg;
import com.tenghong.ndip.model.vo.ResourcesVo;
import com.tenghong.ndip.service.sys.ResourcesService;
import com.tenghong.ndip.utils.SqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 17:17 2018/6/4
 */
@Service
public class ResourcesServiceImpl implements ResourcesService{

    @Autowired
    private SysResourcesMapper sysResourcesMapper;
    @Autowired
    private SysResourcesPkgMapper sysResourcesPkgMapper;
    @Autowired
    private SqlMapper sqlMapper;

    @Override
    public List<ResourcesVo> list(Integer userId) {
        List<ResourcesVo> pList = sysResourcesMapper.getParentTreeNode(userId);
        List<ResourcesVo> list = new ArrayList<>();
        for (ResourcesVo vo : pList){
            List<ResourcesVo> cList = sysResourcesMapper.getChildrenNode(vo.getCode(),userId);
            vo.setChildren(cList);
            list.add(vo);
        }
        return list;
    }

    @Override
    public List<Integer> info(Integer userId) {
        String sql = "select pkg.resources_id from sys_resources_pkg pkg left join sys_resources re on pkg.resources_id = re.id where pkg.user_id = #{userId} and re.levels = 2";
        return sqlMapper.selectList(sql,userId,int.class);
    }

    @Override
    public void delete(Integer userId) {
        String sql = "delete from sys_resources_pkg where user_id = #{userId}";
        sqlMapper.delete(sql,userId);
    }

    @Override
    @Transactional
    public void save(List<Integer> userList, List<Integer> resourcesList) {
        List<SysResourcesPkg> pkgList = new ArrayList<>();
        for (Integer item : userList){
            String sql = "delete from sys_resources_pkg where user_id = #{userId}";
            sqlMapper.delete(sql,item);
            for (Integer resources:resourcesList){
                SysResourcesPkg pkg = new SysResourcesPkg();
                pkg.setUserId(item);
                pkg.setResourcesId(resources);
                pkgList.add(pkg);
            }
        }
        sysResourcesPkgMapper.insertPlus(pkgList);
    }
}
