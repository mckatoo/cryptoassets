/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-02-01 22:42:00
 * @modify date 2019-02-01 22:42:00
 * @desc [description]
 */

package io.ikatoo.cryptoassets.infra.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.ikatoo.cryptoassets.core.entity.UsersType;

/**
 * UsersRepository
 */
public interface IUsersTypeRepository extends PagingAndSortingRepository<UsersType, Long> {
    List<UsersType> findByTypeIgnoreCaseContaining(String type);
}